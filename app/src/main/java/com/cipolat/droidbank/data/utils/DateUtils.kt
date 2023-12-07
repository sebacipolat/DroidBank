package com.cipolat.droidbank.data.utils

object DateUtils {

    fun isTimeStampChild(passedTimeStamp: Long, limitTime: Long): Boolean {
        val actualTimeStamp = System.currentTimeMillis()
        val diff = actualTimeStamp - passedTimeStamp
        return diff < limitTime
    }
}
