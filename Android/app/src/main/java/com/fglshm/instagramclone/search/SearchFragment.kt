package com.fglshm.instagramclone.search

import android.os.Bundle
import android.view.View
import com.fglshm.extensions2.showLogD
import com.fglshm.instagramclone.R
import com.fglshm.instagramclone.common.base.BaseFragment

class SearchFragment : BaseFragment() {

    private val cls = SearchFragment::class
    override fun getLayout(): Int = R.layout.fragment_search

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        cls.showLogD("[ onViewCreated ]")
    }

}