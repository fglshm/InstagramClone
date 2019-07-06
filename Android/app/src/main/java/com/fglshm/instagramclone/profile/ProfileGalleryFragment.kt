package com.fglshm.instagramclone.profile

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import com.fglshm.instagramclone.R
import com.fglshm.instagramclone.base.BaseFragment
import com.fglshm.instagramclone.extension.transact
import kotlinx.android.synthetic.main.fragment_profile_gallery.*

class ProfileGalleryFragment : BaseFragment() {

    override val logTag: String = ProfileGalleryFragment::class.java.simpleName
    override fun getLayout(): Int = R.layout.fragment_profile_gallery

    private val mRecyclerView by lazy { recycler_fragment_profile_gallery }
    private val mAdapter by lazy { ProfileGalleryRecyclerAdapter(mContext) }

    private var hasPost = false

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // もし、サーバーにアクセスして投稿データがあるなら、RecyclerView をセットする
        // なければ、RecyclerView を非表示にして NoPostFragment をセットする
        if (hasPost) {
            setRecyclerView()
        } else {
            setNoPost()
        }

    }

    private fun setNoPost() {
        childFragmentManager.transact {
            replace(
                R.id.container_fragment_profile_gallery,
                ProfileNoPostFragment.newInstance(),
                ProfileNoPostFragment::class.java.simpleName
            )
        }
    }

    private fun setRecyclerView() {
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