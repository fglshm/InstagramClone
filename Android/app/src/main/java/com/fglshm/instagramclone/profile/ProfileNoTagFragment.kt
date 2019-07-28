package com.fglshm.instagramclone.profile

import com.fglshm.instagramclone.R
import com.fglshm.instagramclone.common.base.BaseFragment

class ProfileNoTagFragment : BaseFragment() {

    override fun getLayout(): Int = R.layout.fragment_profile_no_tag

    companion object {
        fun newInstance() = ProfileNoTagFragment()
    }

}