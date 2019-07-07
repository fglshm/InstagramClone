package com.fglshm.instagramclone.timeline

import android.os.Bundle
import android.view.View
import com.fglshm.instagramclone.R
import com.fglshm.instagramclone.base.BaseFragment

class TimelineFragment : BaseFragment() {

    override val logTag: String = TimelineFragment::class.java.simpleName
    override fun getLayout(): Int = R.layout.fragment_timeline

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showLog("[ TimelineFragment ]")
    }

}