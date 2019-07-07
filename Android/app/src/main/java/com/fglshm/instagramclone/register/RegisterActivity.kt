package com.fglshm.instagramclone.register

import android.os.Bundle
import com.fglshm.instagramclone.R
import com.fglshm.instagramclone.base.BaseActivity
import com.fglshm.instagramclone.extension.transact

class RegisterActivity : BaseActivity() {

    override val logTag: String = RegisterActivity::class.java.simpleName
    override fun getLayout(): Int = R.layout.activity_register

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportFragmentManager.transact {
            replace(
                R.id.container_activity_register,
                RegisterEmailFragment.newInstance(),
                RegisterEmailFragment::class.java.simpleName
            )
        }
    }

}