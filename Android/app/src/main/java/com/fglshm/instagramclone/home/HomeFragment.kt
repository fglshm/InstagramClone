package com.fglshm.instagramclone.home

import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import com.fglshm.instagramclone.R
import com.fglshm.instagramclone.base.BaseFragment
import com.fglshm.instagramclone.main.MainActivity
import com.fglshm.instagramclone.main.MainContract
import com.fglshm.instagramclone.timeline.TimelineFragment
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : BaseFragment() {

    override val logTag: String = HomeFragment::class.java.simpleName
    override fun getLayout(): Int = R.layout.fragment_home

    private val containerRes = R.id.container_fragment_home

    private val bottomNavigation by lazy { navigation_fragment_home }

    private val timelineFragment by lazy { TimelineFragment() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setFragment()
        observeBottomNavigation()
    }

    private fun setFragment() {
        childFragmentManager.beginTransaction()
            .replace(containerRes, timelineFragment)
            .commit()
    }

    private fun observeBottomNavigation() {
        bottomNavigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.navigation_home -> {
                    ((mActivity as MainActivity) as MainContract.View).setViewPagerState(true)
                    true
                }
                R.id.navigation_search -> {
                    ((mActivity as MainActivity) as MainContract.View).setViewPagerState(false)
                    true
                }
                R.id.navigation_post -> {
                    ((mActivity as MainActivity) as MainContract.View).setViewPagerState(false)
                    false
                }
                R.id.navigation_like -> {
                    ((mActivity as MainActivity) as MainContract.View).setViewPagerState(false)
                    true
                }
                else -> {
                    ((mActivity as MainActivity) as MainContract.View).setViewPagerState(false)
                    true
                }
            }
        }
    }

}