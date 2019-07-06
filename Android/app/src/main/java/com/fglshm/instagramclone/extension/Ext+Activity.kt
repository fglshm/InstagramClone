package com.fglshm.instagramclone.extension

import android.os.Handler
import androidx.appcompat.app.AppCompatActivity

fun AppCompatActivity.doAfter(delay: Long, action: () -> Unit) {
    Handler().postDelayed({
        run {
            action()
        }
    }, delay)
}