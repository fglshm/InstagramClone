package com.fglshm.instagramclone.notification

import android.os.Bundle
import android.view.View
import com.fglshm.extensions2.showLogD
import com.fglshm.instagramclone.R
import com.fglshm.instagramclone.common.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_notification.*

class NotificationFragment : BaseFragment() {

    private val cls = NotificationFragment::class
    override fun getLayout(): Int = R.layout.fragment_notification

    private val tab by lazy { tab_fragment_notification }
    private val viewPager by lazy { pager_fragment_notification }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView()
    }

    private fun setupView() {
        viewPager.adapter = NotificationPagerAdapter(childFragmentManager)
        tab.setupWithViewPager(viewPager)
    }

}