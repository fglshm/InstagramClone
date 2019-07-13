package com.fglshm.instagramclone.post

import android.os.Bundle
import android.view.View
import com.fglshm.instagramclone.R
import com.fglshm.instagramclone.common.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_post_caption.*

class PostCaptionFragment : BaseFragment() {

    override val logTag: String = PostCaptionFragment::class.java.simpleName
    override fun getLayout(): Int = R.layout.fragment_post_caption

    private val mCloseButton by lazy { image_button_close_fragment_post_caption }

    companion object {
        fun newInstance() = PostCaptionFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mCloseButton.setOnClickListener {
            mActivity.supportFragmentManager.popBackStack()
        }
    }

}