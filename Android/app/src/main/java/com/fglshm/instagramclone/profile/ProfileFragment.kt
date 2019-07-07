package com.fglshm.instagramclone.profile

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.core.view.postDelayed
import com.fglshm.instagramclone.R
import com.fglshm.instagramclone.base.BaseFragment
import com.fglshm.instagramclone.extension.setInvisible
import com.fglshm.instagramclone.extension.setVisible
import com.fglshm.instagramclone.main.MainActivity
import com.fglshm.instagramclone.profile.profileedit.ProfileEditActivity
import com.fglshm.instagramclone.register.RegisterActivity
import com.github.kittinunf.fuel.android.extension.responseJson
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.result.Result
import kotlinx.android.synthetic.main.fragment_profile.*

class ProfileFragment : BaseFragment() {

    override val logTag: String = ProfileFragment::class.java.simpleName
    override fun getLayout(): Int = R.layout.fragment_profile

    private val mTab by lazy { tab_profile }
    private val mViewPager by lazy { pager_profile }
    private val mProgressBar by lazy { progress_fragment_profile }
    private val mEditButton by lazy { button_edit_profile }
    private val mMenuButton by lazy { img_btn_menu_fragment_profile }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // ユーザー情報を取得するまで ProgressBar を表示させる
        // 取得後に、ProgressBar を非表示にする
        mProgressBar.setVisible()
        mProgressBar.postDelayed(1000) {
            mProgressBar.setInvisible()
            mViewPager.adapter = ProfilePagerAdapter(childFragmentManager)
            mTab.setupWithViewPager(mViewPager)
            mTab.getTabAt(0)?.setIcon(R.drawable.ic_grid)
            mTab.getTabAt(1)?.setIcon(R.drawable.ic_people)
            mTab.tabRippleColor = null
        }

        mEditButton.setOnClickListener {
            val intent = Intent(mContext, ProfileEditActivity::class.java)
            (mActivity as MainActivity).apply {
                startActivity(intent)
                overridePendingTransition(R.anim.enter_from_bottom, R.anim.fade_out)
            }
        }

        mMenuButton.setOnClickListener {
            val intent = Intent(mContext, RegisterActivity::class.java)
            mActivity.apply {
                startActivity(intent)
                overridePendingTransition(R.anim.enter_from_bottom, R.anim.fade_out)
                finish()
            }
        }
    }

}