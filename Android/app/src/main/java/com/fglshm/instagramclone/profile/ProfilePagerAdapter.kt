package com.fglshm.instagramclone.profile

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class ProfilePagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {

    override fun getItem(position: Int): Fragment =
        if (position == 0) ProfileGalleryFragment.newInstance()
        else ProfileTagsFragment.newInstance()

    override fun getCount(): Int = 2

}