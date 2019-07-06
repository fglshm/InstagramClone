package com.fglshm.instagramclone.extension

import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

fun Fragment.doAfter(delay: Long, action: () -> Unit) {
    Handler().postDelayed({
        run {
            action()
        }
    }, delay)
}