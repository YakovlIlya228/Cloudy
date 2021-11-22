package com.example.cloudy.utils

import androidx.annotation.DrawableRes
import com.example.cloudy.R
import java.sql.Timestamp
import java.text.SimpleDateFormat
import java.util.*

object Extensions {

//    fun String.getDateFromTimestamp(): String? {
//        return try {
//            val sdf = SimpleDateFormat("dd MMMMM", Locale.US)
//            val netDate = Date(toLong())
//            sdf.format(netDate)
//        } catch (e: Exception) {
//            e.toString()
//        }
//    }

    fun Long.getDateFromTimestamp(): String? {
        return try {
            val ts = Timestamp(this)
            val date = Date(ts.time * 1000)
            val sdf = SimpleDateFormat("dd MMMM", Locale.UK)
            sdf.format(date)
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }


    fun Long.getWeekday(): String? {
        return try {
            val ts = Timestamp(this)
            val date = Date(ts.time * 1000)
            val weekdaySdf = SimpleDateFormat("EE", Locale.UK)
            weekdaySdf.format(date)
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }

    @DrawableRes
    fun Int.parseIcon(): Int? = when (this) {
        801, 802 -> R.drawable.ic_lc
        600, 621, 622, 623 -> R.drawable.ic_sn
        511, 522, 520 -> R.drawable.ic_hr
        500, 501 -> R.drawable.ic_lr
        230, 231, 232, 233 -> R.drawable.ic_t
        800 -> R.drawable.ic_c
        803, 804 -> R.drawable.ic_hc
        611, 612 -> R.drawable.ic_sl
        else -> null
    }

}