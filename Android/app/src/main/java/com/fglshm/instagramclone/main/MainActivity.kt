package com.fglshm.instagramclone.main

import android.os.Bundle
import android.view.View
import com.fglshm.instagramclone.R
import com.fglshm.instagramclone.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity(), MainContract.View {

    override val logTag: String = MainActivity::class.java.simpleName
    override fun getLayout(): Int = R.layout.activity_main

    private val viewPager by lazy { pager_activity_main }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupViewPager()

    }

    private fun setupViewPager() {
        viewPager.apply {
            adapter = MainPagerAdapter(supportFragmentManager)
            offscreenPageLimit = 3
            currentItem = 1
        }
    }

    override fun setViewPagerState(state: Boolean) {
        viewPager.setPagingEnabled(state)
    }

}
