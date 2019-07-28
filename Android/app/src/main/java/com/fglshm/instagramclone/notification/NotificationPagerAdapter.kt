package com.fglshm.instagramclone.notification

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.fglshm.instagramclone.common.data.PagerFragment
import com.fglshm.instagramclone.common.data.TabbarTitle

class NotificationPagerAdapter(
    fm: FragmentManager
) : FragmentStatePagerAdapter(fm) {

    override fun getItem(position: Int): Fragment = PagerFragment.notificaton[position]
    override fun getCount(): Int = 2
    override fun getPageTitle(position: Int): CharSequence? = TabbarTitle.notification[position]

}