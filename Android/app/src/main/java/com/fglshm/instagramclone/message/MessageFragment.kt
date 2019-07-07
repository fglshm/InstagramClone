package com.fglshm.instagramclone.message

import android.os.Bundle
import android.view.View
import com.fglshm.instagramclone.R
import com.fglshm.instagramclone.base.BaseFragment

class MessageFragment : BaseFragment() {

    override val logTag: String = MessageFragment::class.java.simpleName
    override fun getLayout(): Int = R.layout.fragment_message

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.setOnClickListener {
            showLog("[ onViewCreated ]")
        }
    }

}