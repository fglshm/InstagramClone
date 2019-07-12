package com.fglshm.instagramclone.notification

import android.os.Bundle
import android.view.View
import com.fglshm.extensions2.showLogD
import com.fglshm.instagramclone.R
import com.fglshm.instagramclone.common.base.BaseFragment

class NotificationFragment : BaseFragment() {

    private val cls = NotificationFragment::class
    override val logTag: String = NotificationFragment::class.java.simpleName
    override fun getLayout(): Int = R.layout.fragment_notification

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        cls.showLogD("[ onViewCreated ]")
    }

}