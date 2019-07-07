package com.fglshm.instagramclone.register

import android.os.Bundle
import android.view.View
import android.view.inputmethod.EditorInfo
import com.fglshm.instagramclone.R
import com.fglshm.instagramclone.base.BaseFragment
import com.fglshm.instagramclone.extension.setInvisible
import com.fglshm.instagramclone.extension.setVisible
import kotlinx.android.synthetic.main.fragment_register_email.*

class RegisterEmailFragment : BaseFragment() {

    override val logTag: String = RegisterEmailFragment::class.java.simpleName
    override fun getLayout(): Int = R.layout.fragment_register_email

    private val mEmailEdit by lazy { edt_email_fragment_register_email }
    private val mDeleteButton by lazy { img_btn_delete_fragment_register_email }
    private val mNextLayout by lazy { layout_next_fragment_register_email }
    private val mNextText by lazy { txt_next_fragment_register_email }
    private val mProgressBar by lazy { progress_fragment_register_email }

    companion object {
        fun newInstance() = RegisterEmailFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mEmailEdit.setOnEditorActionListener { v, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                mInputMethodManager.hideSoftInputFromWindow(mEmailEdit.windowToken, 0)
                mEmailEdit.clearFocus()
            }
            false
        }
        mDeleteButton.setOnClickListener {
            mEmailEdit.text = null
        }
        mNextLayout.setOnClickListener {
            mNextText.setInvisible()
            mProgressBar.setVisible()
        }
    }
}