package com.fglshm.instagramclone.register

import android.os.Bundle
import com.fglshm.extensions2.transact
import com.fglshm.instagramclone.R
import com.fglshm.instagramclone.common.base.BaseActivity

class RegisterActivity : BaseActivity() {

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