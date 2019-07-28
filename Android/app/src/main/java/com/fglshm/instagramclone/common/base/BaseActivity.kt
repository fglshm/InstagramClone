package com.fglshm.instagramclone.common.base

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.fglshm.extensions2.screenHeight
import com.fglshm.extensions2.screenWidth

abstract class BaseActivity : AppCompatActivity() {

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