package com.fglshm.instagramclone.post

import com.fglshm.instagramclone.R
import com.fglshm.instagramclone.common.base.BaseActivity

class PostActivity : BaseActivity() {

    override val logTag: String = PostActivity::class.java.simpleName
    override fun getLayout(): Int = R.layout.activity_post

    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(R.anim.fade_in, R.anim.exit_to_bottom)
    }

}