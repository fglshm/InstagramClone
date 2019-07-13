package com.fglshm.instagramclone.common.base

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

abstract class BaseFragment : Fragment() {

    abstract val logTag: String
    abstract fun getLayout(): Int

    protected lateinit var mContext: Context
    protected lateinit var mActivity: AppCompatActivity
    protected lateinit var mInputMethodManager: InputMethodManager

    override fun onAttach(context: Context) {
        super.onAttach(context)
        this.mContext = context
        this.mActivity = context as AppCompatActivity
        this.mInputMethodManager = this.mActivity.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(getLayout(), container, false)
    }

    protected fun showLog(message: Any?) {
        Log.d(logTag, message?.toString() ?: "NO TEXT")
    }

}