package com.fglshm.instagramclone.profile.profileedit

import android.os.Bundle
import android.os.Handler
import androidx.recyclerview.widget.LinearLayoutManager
import com.fglshm.instagramclone.R
import com.fglshm.instagramclone.base.BaseActivity
import com.fglshm.instagramclone.extension.doAfter
import com.fglshm.instagramclone.extension.setInvisible
import com.fglshm.instagramclone.extension.setVisible
import kotlinx.android.synthetic.main.activity_profile_edit.*

class ProfileEditActivity : BaseActivity() {

    override val logTag: String = ProfileEditActivity::class.java.simpleName
    override fun getLayout(): Int = R.layout.activity_profile_edit

    private val mBackButton by lazy { img_btn_back_activity_profile_edit }
    private val mRecyclerView by lazy { recycler_activity_profile_edit }
    private val mAdapter by lazy { ProfileEditRecyclerAdapter() }
    private val mPrivacyRecyclerView by lazy { recycler_privacy_activity_profile_edit }
    private val mPrivacyAdapter by lazy { ProfileEditRecyclerAdapter() }
    private val mCheckButton by lazy { img_btn_check_activity_profile_edit }
    private val mProgressBar by lazy { progress_toolbar_activity_profile_edit }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBackButton.setOnClickListener {
            onBackPressed()
        }
        mRecyclerView.apply {
            adapter = mAdapter
            layoutManager = LinearLayoutManager(context)
        }
        mAdapter.addAll(detailItems())
        mPrivacyRecyclerView.apply {
            adapter = mPrivacyAdapter
            layoutManager = LinearLayoutManager(context)
        }
        mPrivacyAdapter.addAll(privacyDetailItems())
        mCheckButton.setOnClickListener {
            mCheckButton.setInvisible()
            mProgressBar.setVisible()
            doAfter(1500) {
                mProgressBar.setInvisible()
                mCheckButton.setVisible()
                onBackPressed()
            }
        }
    }

    private fun detailItems() = listOf(
        DetailItem(DetailType.NAME, "Name", "shohei"),
        DetailItem(DetailType.USERNAME, "Usename", "fgl___1"),
        DetailItem(DetailType.NAME, "Website", "https://github.com/fglshm"),
        DetailItem(DetailType.NAME, "Bio", "💻 Kotlin and Swift")
    )

    private fun privacyDetailItems() = listOf(
        DetailItem(DetailType.NAME, "E-mail Address", "fglshm@gmail.com"),
        DetailItem(DetailType.USERNAME, "Phone number", "+81 0000000000")
    )

    override fun onBackPressed() {
        finish()
        overridePendingTransition(R.anim.fade_in, R.anim.exit_to_bottom)
    }

}