package com.fglshm.instagramclone.main

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.fglshm.instagramclone.camera.CameraFragment
import com.fglshm.instagramclone.home.HomeFragment
import com.fglshm.instagramclone.message.MessageFragment

class MainPagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {

    override fun getItem(position: Int): Fragment = when (position) {
        0 -> CameraFragment()
        1 -> HomeFragment()
        else -> MessageFragment()
    }

    override fun getCount(): Int = 3
}
