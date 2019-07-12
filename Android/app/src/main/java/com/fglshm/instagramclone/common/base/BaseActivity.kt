package com.fglshm.instagramclone.common.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.fglshm.extensions2.screenHeight
import com.fglshm.extensions2.screenWidth

abstract class BaseActivity : AppCompatActivity() {

    abstract val logTag: String
    abstract fun getLayout(): Int

    protected var screenWidth = 0
    protected var screenHeight = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayout())
        screenWidth = screenWidth()
        screenHeight = screenHeight()
    }

}