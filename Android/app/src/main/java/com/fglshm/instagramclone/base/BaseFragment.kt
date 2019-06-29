package com.fglshm.instagramclone.base

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.fglshm.instagramclone.main.MainActivity

abstract class BaseFragment : Fragment() {

    abstract val logTag: String
    abstract fun getLayout(): Int

    protected var mContext: Context? = null
    protected var mActivity: AppCompatActivity? = null

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        this.mContext = context
        this.mActivity = context as? MainActivity
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(getLayout(), container, false)
    }

    fun log(message: Any?) {
        Log.d(logTag, message?.toString() ?: "no message")
    }

}