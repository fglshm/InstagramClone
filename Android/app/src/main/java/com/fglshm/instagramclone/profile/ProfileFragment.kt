package com.fglshm.instagramclone.profile

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.core.view.postDelayed
import com.fglshm.extensions2.setInvisible
import com.fglshm.extensions2.setVisible
import com.fglshm.extensions2.showLogD
import com.fglshm.instagramclone.R
import com.fglshm.instagramclone.common.base.BaseFragment
import com.fglshm.instagramclone.main.MainActivity
import com.fglshm.instagramclone.profile.profileedit.ProfileEditActivity
import com.fglshm.instagramclone.register.RegisterActivity
import kotlinx.android.synthetic.main.fragment_profile.*

class ProfileFragment : BaseFragment() {

    private val cls = ProfileFragment::class
    override fun getLayout(): Int = R.layout.fragment_profile

    private val mTab by lazy { tab_profile }
    private val mViewPager by lazy { pager_profile }
    private val mProgressBar by lazy { progress_fragment_profile }
    private val mEditButton by lazy { button_edit_profile }
    private val mMenuButton by lazy { img_btn_menu_fragment_profile }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        cls.showLogD("[ onViewCreated ]")

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