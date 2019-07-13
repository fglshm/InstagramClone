package com.fglshm.instagramclone.post

import android.os.Bundle
import android.view.View
import com.fglshm.instagramclone.R
import com.fglshm.instagramclone.common.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_post_customize.*

class PostCustomizeFragment : BaseFragment() {

    override val logTag: String = PostCustomizeFragment::class.java.simpleName
    override fun getLayout(): Int = R.layout.fragment_post_customize

    private val mCloseButton by lazy { image_button_close_fragment_post_customize }
    private val mNextButton by lazy { button_next_fragment_post_customize }

    companion object {
        fun newInstance() = PostCustomizeFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mCloseButton.setOnClickListener {
            mActivity.supportFragmentManager.popBackStack()
        }
        mNextButton.setOnClickListener {
            (mActivity as PostActivity).showPostCaption()
        }
    }

}