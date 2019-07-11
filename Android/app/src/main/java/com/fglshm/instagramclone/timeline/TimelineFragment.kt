package com.fglshm.instagramclone.timeline

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.fglshm.extensions2.doAfter
import com.fglshm.extensions2.scale
import com.fglshm.extensions2.showLogD
import com.fglshm.instagramclone.R
import com.fglshm.instagramclone.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_timeline.*

class TimelineFragment : BaseFragment() {

    override val logTag: String = TimelineFragment::class.java.simpleName
    override fun getLayout(): Int = R.layout.fragment_timeline
    private val cls = TimelineFragment::class

    private val mRefresh by lazy { refresh_fragment_timeline }
    private val mStoryRecyclerView by lazy { recycler_story_fragment_timeline }
    private val mStoryAdapter by lazy { TimelineStoryAdapter() }
    private val mFeedRecyclerView by lazy { recycler_feed_fragment_timeline }
    private val mFeedAdapter by lazy { TimelineFeedAdapter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        setListener()
    }

    private fun setListener() {
        mRefresh.setOnRefreshListener {
            mStoryAdapter.clear()
            mFeedAdapter.clear()
            mContext.doAfter(1500) {
                mRefresh.isRefreshing = false
                setupRecyclerView()
            }
        }
    }

    private fun setupRecyclerView() {
        mStoryRecyclerView.adapter = mStoryAdapter
        repeat(10) {
            mStoryAdapter.add("")
        }
        mFeedRecyclerView.apply {
            adapter = mFeedAdapter
            addItemDecoration(ItemDecoration(mActivity.scale(), 12))
        }
        repeat(10) {
            mFeedAdapter.add("")
        }
    }

}