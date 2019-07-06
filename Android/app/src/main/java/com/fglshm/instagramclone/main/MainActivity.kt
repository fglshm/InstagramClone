package com.fglshm.instagramclone.main

import android.os.Bundle
import android.view.View
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.fglshm.instagramclone.R
import com.fglshm.instagramclone.base.BaseActivity
import com.fglshm.instagramclone.drawer.DrawerFragment
import com.fglshm.instagramclone.extension.transact
import com.fglshm.instagramclone.utils.Utils
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity(), MainContract.View {

    override val logTag: String = MainActivity::class.java.simpleName
    override fun getLayout(): Int = R.layout.activity_main

    private val mDrawerLayout by lazy { drawer_activity_main }
    private val mViewPager by lazy { pager_activity_main }
    private val mDrawerContent by lazy { drawer_content_activity_main }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupViewPager()
        setDrawerFragment()
        setupDrawerLayout()
    }

    private fun setDrawerFragment() {
        supportFragmentManager.transact {
            replace(R.id.drawer_content_activity_main, DrawerFragment(), DrawerFragment::class.java.simpleName)
        }
    }

    private fun setupViewPager() {
        mViewPager.apply {
            adapter = MainPagerAdapter(supportFragmentManager)
            offscreenPageLimit = 3
            currentItem = 1
        }
    }

    private fun setupDrawerLayout() {
        mDrawerContent.apply {
            requestLayout()
            layoutParams.width = screenWidth.div(3).times(2)
        }
        val drawerListener = object : DrawerLayout.DrawerListener {
            override fun onDrawerStateChanged(newState: Int) {}
            override fun onDrawerOpened(drawerView: View) {}
            override fun onDrawerClosed(drawerView: View) {}

            override fun onDrawerSlide(drawerView: View, slideOffset: Float) {
                mViewPager.translationX = -mDrawerContent.width.times(slideOffset)
            }
        }
        mDrawerLayout.addDrawerListener(drawerListener)
        mDrawerLayout.setScrimColor(resources.getColor(android.R.color.transparent, null))
        mDrawerLayout.drawerElevation = 0F

        setDrawerLock(true)
    }

    override fun setViewPagerState(state: Boolean) {
        mViewPager.setPagingEnabled(state)
    }

    override fun openDrawer() {
        mDrawerLayout.openDrawer(GravityCompat.END)
    }

    override fun setDrawerLock(state: Boolean) {
        val mode = if (state) DrawerLayout.LOCK_MODE_LOCKED_CLOSED else DrawerLayout.LOCK_MODE_UNLOCKED
        mDrawerLayout.setDrawerLockMode(mode)
    }

}
