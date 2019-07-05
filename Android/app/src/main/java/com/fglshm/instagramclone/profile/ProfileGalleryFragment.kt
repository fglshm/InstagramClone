package com.fglshm.instagramclone.profile

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import com.fglshm.instagramclone.R
import com.fglshm.instagramclone.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_profile_gallery.*

class ProfileGalleryFragment : BaseFragment() {

    override val logTag: String = ProfileGalleryFragment::class.java.simpleName
    override fun getLayout(): Int = R.layout.fragment_profile_gallery

    private val mRecyclerView by lazy { recycler_fragment_profile_gallery }
    private val mAdapter by lazy { ProfileGalleryRecyclerAdapter(mContext) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mRecyclerView.apply {
            adapter = mAdapter
            layoutManager = GridLayoutManager(mContext, 3)
            setHasFixedSize(true)
        }
        repeat(100) {
            mAdapter.add("")
        }
    }

}