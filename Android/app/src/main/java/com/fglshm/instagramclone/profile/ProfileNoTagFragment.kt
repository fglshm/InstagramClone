package com.fglshm.instagramclone.profile

import com.fglshm.instagramclone.R
import com.fglshm.instagramclone.base.BaseFragment

class ProfileNoTagFragment : BaseFragment() {

    override val logTag: String = ProfileNoTagFragment::class.java.simpleName
    override fun getLayout(): Int = R.layout.fragment_profile_no_tag

    companion object {
        fun newInstance() = ProfileNoTagFragment()
    }

}