package com.fglshm.instagramclone.main

interface MainContract {

    interface View {

        fun setViewPagerState(state: Boolean)

        fun openDrawer()

        fun setDrawerLock(state: Boolean)
    }

}