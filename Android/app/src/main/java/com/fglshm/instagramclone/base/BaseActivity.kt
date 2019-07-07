package com.fglshm.instagramclone.base

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.fglshm.instagramclone.utils.Utils

abstract class BaseActivity : AppCompatActivity() {

    abstract val logTag: String
    abstract fun getLayout(): Int

    protected var screenWidth = 0
    protected var screenHeight = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayout())
        screenWidth = Utils.Size.getScreenWidth(this)
        screenHeight = Utils.Size.getScreenHeight(this)
    }

    fun showLog(message: Any?) {
        Log.d(logTag, message?.toString() ?: "no message")
    }

}