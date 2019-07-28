package com.fglshm.instagramclone.main

import android.os.Bundle
import com.fglshm.instagramclone.R
import com.fglshm.instagramclone.common.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity(), MainContract.View {

    override fun getLayout(): Int = R.layout.activity_main

    private val mViewPager by lazy { pager_activity_main }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupViewPager()
    }

    private fun setupViewPager() {
        mViewPager.apply {
            adapter = MainPagerAdapter(supportFragmentManager)
            offscreenPageLimit = 3
            currentItem = 1
        }
    }

    override fun setViewPagerState(state: Boolean) {
        mViewPager.setPagingEnabled(state)
    }

}
