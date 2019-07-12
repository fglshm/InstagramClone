package com.fglshm.instagramclone.profile

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import com.fglshm.extensions2.transact
import com.fglshm.instagramclone.R
import com.fglshm.instagramclone.common.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_profile_tags.*

class ProfileTagsFragment : BaseFragment() {

    override val logTag: String = ProfileTagsFragment::class.java.simpleName
    override fun getLayout(): Int = R.layout.fragment_profile_tags

    private val mRecyclerView by lazy { recycler_fragment_profile_tags }
    private val mAdapter by lazy { ProfileGalleryRecyclerAdapter(mContext) }

    private var hasPost = false

    companion object {
        fun newInstance() = ProfileTagsFragment()
    }

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
                R.id.container_fragment_profile_tags,
                ProfileNoTagFragment.newInstance(),
                ProfileNoTagFragment::class.java.simpleName
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