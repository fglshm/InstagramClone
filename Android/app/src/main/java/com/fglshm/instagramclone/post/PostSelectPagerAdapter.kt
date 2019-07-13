package com.fglshm.instagramclone.post

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class PostSelectPagerAdapter(
    fm: FragmentManager
) : FragmentStatePagerAdapter(fm) {

    companion object {
        private val TITLES = listOf("GALLERY", "PHOTO", "VIDEO")
        private val FRAGMENTS =
            listOf(PostSelectGalleryFragment(), PostSelectPhotoFragment(), PostSelectVideoFragment())
    }

    override fun getItem(position: Int): Fragment = FRAGMENTS[position]
    override fun getCount(): Int = 3
    override fun getPageTitle(position: Int): CharSequence? = TITLES[position]

}