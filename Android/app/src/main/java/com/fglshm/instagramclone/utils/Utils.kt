package com.fglshm.instagramclone.utils

object Utils {

    object Time {
        fun getTimestampText(nowTimestamp: Long, timestamp: Long): String {

            var timeLag = (nowTimestamp - timestamp * 1000) / 1000

            if (timeLag < 60) {
                return "数秒前"
            }

            when {
                timeLag / 60 < 60 -> {
                    timeLag /= 60
                    return "$timeLag 分前"
                }
                timeLag / 60 / 60 < 24 -> {
                    timeLag = timeLag / 60 / 60
                    return "$timeLag 時間前"
                }
                timeLag / 60 / 60 / 24 < 7 -> {
                    timeLag = timeLag / 60 / 60 / 24
                    if (timeLag == 1L) {
                        return "$timeLag 日前"
                    }
                    return "$timeLag 日前"
                }
                timeLag / 60 / 60 / 24 / 7 < 4 -> {
                    timeLag = timeLag / 60 / 60 / 24 / 7
                    return "$timeLag 週間前"
                }
                timeLag / 60 / 60 / 24 / 7 / 4 < 12 -> {
                    timeLag = timeLag / 60 / 60 / 24 / 7 / 4
                    return "$timeLag ヶ月前"
                }
                else -> {
                    timeLag = timeLag / 60 / 60 / 24 / 7 / 4 / 12
                    return "$timeLag 年前"
                }
            }
        }
    }

}