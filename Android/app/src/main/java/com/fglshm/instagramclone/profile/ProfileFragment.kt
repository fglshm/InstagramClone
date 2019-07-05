package com.fglshm.instagramclone.profile

import android.os.Bundle
import android.view.View
import androidx.core.view.get
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.fglshm.instagramclone.R
import com.fglshm.instagramclone.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_profile.*

class ProfileFragment : BaseFragment() {

    override val logTag: String = ProfileFragment::class.java.simpleName
    override fun getLayout(): Int = R.layout.fragment_profile

    private val tab by lazy { tab_profile }
    private val viewPager by lazy { pager_profile }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewPager.adapter = PagerAdapter(childFragmentManager)
        tab.setupWithViewPager(viewPager)
        tab.getTabAt(0)?.setIcon(R.drawable.ic_grid)
        tab.getTabAt(1)?.setIcon(R.drawable.ic_people)
        tab.tabRippleColor = null
    }

    class PagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {

        override fun getItem(position: Int): Fragment = ProfileGalleryFragment()
        override fun getCount(): Int = 2

    }
}