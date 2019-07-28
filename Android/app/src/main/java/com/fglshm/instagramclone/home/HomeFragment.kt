package com.fglshm.instagramclone.home

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.fglshm.extensions2.showLogD
import com.fglshm.extensions2.transact
import com.fglshm.instagramclone.R
import com.fglshm.instagramclone.common.base.BaseFragment
import com.fglshm.instagramclone.main.MainActivity
import com.fglshm.instagramclone.main.MainContract
import com.fglshm.instagramclone.notification.NotificationFragment
import com.fglshm.instagramclone.post.PostActivity
import com.fglshm.instagramclone.profile.ProfileFragment
import com.fglshm.instagramclone.search.SearchFragment
import com.fglshm.instagramclone.timeline.TimelineFragment
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : BaseFragment() {

    private val cls = HomeFragment::class
    override fun getLayout(): Int = R.layout.fragment_home

    private val containerRes = R.id.container_fragment_home

    private val mNavigation by lazy { navigation_fragment_home }

    private val timelineFragment by lazy { TimelineFragment() }
    private val searchFragment by lazy { SearchFragment() }
    private val notificationFragment by lazy { NotificationFragment() }
    private val profileFragment by lazy { ProfileFragment() }

    private lateinit var currentFragment: BaseFragment

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setFragment()
        observeBottomNavigation()
        observeBaskStack()
    }

    private fun setFragment() {
        currentFragment = timelineFragment
        childFragmentManager.transact {
            replace(containerRes, timelineFragment)
            add(containerRes, searchFragment)
            hide(searchFragment)
            add(containerRes, notificationFragment)
            hide(notificationFragment)
            add(containerRes, profileFragment)
            hide(profileFragment)
        }
    }

    private fun observeBottomNavigation() {
        mNavigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.navigation_home -> {
                    ((mActivity as MainActivity) as MainContract.View).setViewPagerState(true)
                    handleNavigation(timelineFragment)
                    true
                }
                R.id.navigation_search -> {
                    ((mActivity as MainActivity) as MainContract.View).setViewPagerState(false)
                    handleNavigation(searchFragment)
                    true
                }
                R.id.navigation_post -> {
                    ((mActivity as MainActivity) as MainContract.View).setViewPagerState(false)
                    showPostActivity()
                    false
                }
                R.id.navigation_like -> {
                    ((mActivity as MainActivity) as MainContract.View).setViewPagerState(false)
                    handleNavigation(notificationFragment)
                    true
                }
                else -> {
                    ((mActivity as MainActivity) as MainContract.View).setViewPagerState(false)
                    handleNavigation(profileFragment)
                    true
                }
            }
        }
    }

    private fun handleNavigation(newFragment: BaseFragment) {
        if (currentFragment != newFragment) {
            childFragmentManager.transact {
                hide(currentFragment)
                show(newFragment)
            }
            currentFragment = newFragment
        }
    }

    private fun showPostActivity() {
        val intent = Intent(mContext, PostActivity::class.java)
        mActivity.apply {
            startActivity(intent)
            overridePendingTransition(R.anim.enter_from_bottom, R.anim.fade_out)
        }
    }

    private fun observeBaskStack() {
        childFragmentManager.addOnBackStackChangedListener {
            cls.showLogD(childFragmentManager.backStackEntryCount)
        }
    }

}