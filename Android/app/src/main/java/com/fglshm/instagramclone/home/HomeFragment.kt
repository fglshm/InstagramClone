package com.fglshm.instagramclone.home

import android.os.Bundle
import android.view.View
import com.fglshm.extensions2.showLogD
import com.fglshm.extensions2.transact
import com.fglshm.instagramclone.R
import com.fglshm.instagramclone.common.base.BaseFragment
import com.fglshm.instagramclone.main.MainActivity
import com.fglshm.instagramclone.main.MainContract
import com.fglshm.instagramclone.notification.NotificationFragment
import com.fglshm.instagramclone.profile.ProfileFragment
import com.fglshm.instagramclone.search.SearchFragment
import com.fglshm.instagramclone.timeline.TimelineFragment
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : BaseFragment() {

    private val cls = HomeFragment::class
    override val logTag: String = HomeFragment::class.java.simpleName
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
            cls.showLogD(currentFragment)
            when (it.itemId) {
                R.id.navigation_home -> {
                    ((mActivity as MainActivity) as MainContract.View).setViewPagerState(true)
                    if (currentFragment !is TimelineFragment) {
                        childFragmentManager.transact {
                            hide(currentFragment)
                            show(timelineFragment)
                        }
                        currentFragment = timelineFragment
                    }
                    true
                }
                R.id.navigation_search -> {
                    ((mActivity as MainActivity) as MainContract.View).setViewPagerState(false)
                    if (currentFragment !is SearchFragment) {
                        childFragmentManager.transact {
                            hide(currentFragment)
                            show(searchFragment)
                        }
                        currentFragment = searchFragment
                    }
                    true
                }
                R.id.navigation_post -> {
                    ((mActivity as MainActivity) as MainContract.View).setViewPagerState(false)
                    false
                }
                R.id.navigation_like -> {
                    ((mActivity as MainActivity) as MainContract.View).setViewPagerState(false)
                    if (currentFragment !is NotificationFragment) {
                        childFragmentManager.transact {
                            hide(currentFragment)
                            show(notificationFragment)
                        }
                        currentFragment = notificationFragment
                    }
                    true
                }
                else -> {
                    ((mActivity as MainActivity) as MainContract.View).setViewPagerState(false)
                    if (currentFragment !is ProfileFragment) {
                        childFragmentManager.transact {
                            hide(currentFragment)
                            show(profileFragment)
                        }
                        currentFragment = profileFragment
                    }
                    true
                }
            }
        }
    }

    private fun observeBaskStack() {
        childFragmentManager.addOnBackStackChangedListener {
            cls.showLogD(childFragmentManager.backStackEntryCount)
        }
    }

}