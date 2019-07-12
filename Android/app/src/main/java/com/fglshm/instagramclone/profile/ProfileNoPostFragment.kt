package com.fglshm.instagramclone.profile

import com.fglshm.instagramclone.R
import com.fglshm.instagramclone.common.base.BaseFragment

class ProfileNoPostFragment : BaseFragment() {

    override val logTag: String = ProfileNoPostFragment::class.java.simpleName
    override fun getLayout(): Int = R.layout.fragment_profile_no_post

    companion object {
        fun newInstance() = ProfileNoPostFragment()
    }

}