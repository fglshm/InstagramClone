package com.fglshm.instagramclone.message

import android.os.Bundle
import android.view.View
import com.fglshm.instagramclone.R
import com.fglshm.instagramclone.common.base.BaseFragment

class MessageFragment : BaseFragment() {

    override fun getLayout(): Int = R.layout.fragment_message

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.setOnClickListener {
        }
    }

}