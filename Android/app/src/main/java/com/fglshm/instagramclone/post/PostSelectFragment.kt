package com.fglshm.instagramclone.post

import android.os.Bundle
import android.view.View
import com.fglshm.instagramclone.R
import com.fglshm.instagramclone.common.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_post_select.*

class PostSelectFragment : BaseFragment() {

    override val logTag: String = PostSelectFragment::class.java.simpleName
    override fun getLayout(): Int = R.layout.fragment_post_select

    private val mCloseButton by lazy { image_button_close_fragment_post_select }
    private val mSpinnerLayout by lazy { layout_spinner_fragment_post_select }
    private val mSpinner by lazy { spinner_fragment_post_select }
    private val mNextButton by lazy { button_next_fragment_post_select }
    private val mViewPager by lazy { pager_fragment_post_select }
    private val mTab by lazy { tab_fragment_post_select }

    companion object {
        fun newInstance() = PostSelectFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView()

        mCloseButton.setOnClickListener {
            mActivity.onBackPressed()
        }
        mNextButton.setOnClickListener {
            (mActivity as PostActivity).showPostCustomize()
        }
    }

    private fun setupView() {
        mViewPager.adapter = PostSelectPagerAdapter(childFragmentManager)
        mViewPager.offscreenPageLimit = 3
        mTab.setupWithViewPager(mViewPager)
    }

}