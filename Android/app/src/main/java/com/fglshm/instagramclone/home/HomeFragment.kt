package com.fglshm.instagramclone.home

import android.graphics.Color
import android.os.Bundle
import android.view.View
import com.fglshm.instagramclone.R
import com.fglshm.instagramclone.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : BaseFragment() {

    override val logTag: String = HomeFragment::class.java.simpleName
    override fun getLayout(): Int = R.layout.fragment_home

    private val navigation by lazy { navigation_fragment_home }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        handleNavigation()
    }

    private fun handleNavigation() {
        navigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.navigation_home -> {
                    true
                }
                R.id.navigation_search -> {
                    true
                }
                R.id.navigation_post -> {
                    false
                }
                R.id.navigation_like -> {
                    true
                }
                else -> {
                    true
                }
            }
        }
    }
}