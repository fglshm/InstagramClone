package com.fglshm.instagramclone.post

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.os.Bundle
import android.view.WindowManager
import com.fglshm.extensions2.transact
import com.fglshm.instagramclone.R
import com.fglshm.instagramclone.common.base.BaseActivity
import android.view.ViewTreeObserver
import android.widget.LinearLayout
import com.fglshm.extensions2.doAfter


class PostActivity : BaseActivity(), PostContract {

    override val logTag: String = PostActivity::class.java.simpleName
    override fun getLayout(): Int = R.layout.activity_post

    private val containerRes = R.id.container_activity_post

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        hideStatusBar()
        showPostSelect()
        observeBaskStack()
    }

    private fun hideStatusBar() {
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
    }

    private fun showStatusBar() {
        window.clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
    }

    private fun observeBaskStack() {
        supportFragmentManager.addOnBackStackChangedListener {
            if (supportFragmentManager.fragments.last() !is PostCaptionFragment) {
                hideStatusBar()
            } else {
                showStatusBar()
            }
        }
    }

    override fun showPostSelect() {
        val postSelectFragment = PostSelectFragment.newInstance()
        supportFragmentManager.transact {
            replace(containerRes, postSelectFragment, postSelectFragment::class.java.simpleName)
        }
    }

    override fun showPostCustomize() {
        val postCustomizeFragment = PostCustomizeFragment.newInstance()
        supportFragmentManager.transact {
            add(containerRes, postCustomizeFragment, postCustomizeFragment::class.java.simpleName)
            addToBackStack(null)
        }
    }

    override fun showPostCaption() {
        showProcessingPopup {
            val postCaptionFragment = PostCaptionFragment.newInstance()
            supportFragmentManager.transact {
                add(containerRes, postCaptionFragment, postCaptionFragment::class.java.simpleName)
                addToBackStack(null)
            }
        }
    }

    @SuppressLint("InflateParams")
    private fun showProcessingPopup(callback: () -> Unit) {
        val builder = AlertDialog.Builder(this)
        val dialog = builder.create()
        dialog.setCancelable(false)
        dialog.show()

        val window = dialog.window
        window?.setContentView(R.layout.popup_post_process)

        val dialogContainer = window?.findViewById(R.id.container) as LinearLayout
        dialogContainer.viewTreeObserver.addOnGlobalLayoutListener(object : ViewTreeObserver.OnGlobalLayoutListener {
            override fun onGlobalLayout() {
                val width = dialogContainer.width.plus(100)
                window.setLayout(width, WindowManager.LayoutParams.WRAP_CONTENT)
                dialogContainer.viewTreeObserver.removeOnGlobalLayoutListener(this)
            }
        })

        doAfter(1000) {
            dialog.dismiss()
            callback()
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(R.anim.fade_in, R.anim.exit_to_bottom)
    }

}