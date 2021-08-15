package com.example.cloudy.utils

import androidx.annotation.DrawableRes
import com.example.cloudy.R
import java.text.SimpleDateFormat
import java.util.*

object Extensions {

    fun String.getDateFromTimestamp(): String? {
        return try {
            val sdf = SimpleDateFormat("dd MMMMM", Locale.US)
            val netDate = Date(toLong())
            sdf.format(netDate)
        } catch (e: Exception) {
            e.toString()
        }
    }

    fun String.getWeekday(): String? {
        return try {
            val sdf = SimpleDateFormat("MM/dd/yyyy", Locale.US)
            val formattedDate = sdf.format(this)
            val date = sdf.parse(formattedDate)
            val weekdaySdf = SimpleDateFormat("EE", Locale.US)
            if (date != null) weekdaySdf.format(date) else null
        } catch (e: Exception) {
            e.toString()
        }
    }

    @DrawableRes
    fun Int.parseIcon(): Int? = when (this) {
        801, 802 -> R.drawable.ic_lc
        621, 622, 623 -> R.drawable.ic_sn
        511, 522, 520 -> R.drawable.ic_hr
        500, 501 -> R.drawable.ic_lr
        230, 231, 232, 233 -> R.drawable.ic_t
        800 -> R.drawable.ic_c
        803, 804 -> R.drawable.ic_hc
        611, 612 -> R.drawable.ic_sl
        else -> null
    }

}