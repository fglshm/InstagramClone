package com.fglshm.instagramclone.utils

import android.util.DisplayMetrics
import androidx.appcompat.app.AppCompatActivity

object Utils {

    object Size {

        fun getScreenWidth(context: AppCompatActivity): Int {
            val displayMetrics = DisplayMetrics()
            context.windowManager.defaultDisplay.getMetrics(displayMetrics)
            return displayMetrics.widthPixels
        }

        fun getScreenHeight(context: AppCompatActivity): Int {
            val displayMetrics = DisplayMetrics()
            context.windowManager.defaultDisplay.getMetrics(displayMetrics)
            return displayMetrics.heightPixels
        }

        fun getScale(context: AppCompatActivity): Int {
            return context.resources.displayMetrics.density.toInt()
        }

    }

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