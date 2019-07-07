package com.fglshm.instagramclone.main

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.fglshm.instagramclone.R
import com.fglshm.instagramclone.base.BaseActivity
import com.fglshm.instagramclone.drawer.DrawerFragment
import com.fglshm.instagramclone.extension.transact
import com.fglshm.instagramclone.utils.Utils
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity(), MainContract.View {

    override val logTag: String = MainActivity::class.java.simpleName
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
