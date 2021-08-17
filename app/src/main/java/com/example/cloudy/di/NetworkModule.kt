package com.example.cloudy.di

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.cloudy.BuildConfig
import com.example.cloudy.source.api.ApiRepository
import com.example.cloudy.source.api.ApiRepositoryImp
import com.example.cloudy.source.api.ApiService
import okhttp3.*
import okhttp3.ResponseBody.Companion.toResponseBody
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException
import java.util.*
import java.util.concurrent.TimeUnit
import kotlin.io.path.ExperimentalPathApi

const val DEFAULT_TIMEOUT: Long = 60

val networkModule = module {

    single<Retrofit> {
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BuildConfig.BASE_URL)
            .client(get())
            .build()
    }

    single<ApiService> {
        get<Retrofit>().create(ApiService::class.java)
    }

    single {
        HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BASIC
        }
    }

    single<ApiRepository> { ApiRepositoryImp(get()) }

    single {
        OkHttpClient.Builder()
            .addInterceptor(OkHttpLogoInterceptor())
            .addInterceptor(get<HttpLoggingInterceptor>())
            .cache(null)
            .connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
            .writeTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
            .build()
    }
}


class OkHttpLogoInterceptor : Interceptor {
    @ExperimentalPathApi
    @RequiresApi(Build.VERSION_CODES.O)
    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val request: Request = chain.request()
        println(
            "okhttp " + String.format(
                "Sending request %s on %s%n%s", request.url,
                chain.connection(), request.headers
            )
        )
        val t1 = System.nanoTime()
        val response: Response = chain.proceed(chain.request())
        val t2 = System.nanoTime()
        println(
            "okhttp " + String.format(
                Locale.getDefault(), "Received response from %s in %.1f ms %n%s",
                response.request.url, (t2 - t1) / 1e6, response.headers
            )
        )
        val mediaType: MediaType? = response.body?.contentType()
        val content: String? = response.body?.string()
        if (content != null) {
            println("okhttp $content")
        }
        return response.newBuilder()
            .body((content ?: "").toResponseBody(mediaType))
            .build()
    }
}
