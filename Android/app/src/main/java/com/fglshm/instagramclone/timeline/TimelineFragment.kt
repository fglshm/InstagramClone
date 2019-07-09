package com.fglshm.instagramclone.timeline

import android.os.Bundle
import android.view.View
import com.fglshm.instagramclone.R
import com.fglshm.instagramclone.base.BaseFragment
import com.fglshm.instagramclone.extension.doAfter
import kotlinx.android.synthetic.main.fragment_timeline.*

class TimelineFragment : BaseFragment() {

    override val logTag: String = TimelineFragment::class.java.simpleName
    override fun getLayout(): Int = R.layout.fragment_timeline

    private val mRefresh by lazy { refresh_fragment_timeline }
    private val mFeedRecyclerView by lazy { recycler_feed_fragment_timeline }
    private val mFeedAdapter by lazy { TimelineFeedAdapter() }
    private val mStoryRecyclerView by lazy { recycler_story_fragment_timeline }
    private val mStoryAdapter by lazy { TimelineStoryAdapter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        setListener()
    }

    private fun setListener() {
        mRefresh.setOnRefreshListener {
            mFeedAdapter.clear()
            doAfter(1500) {
                mRefresh.isRefreshing = false
                setupRecyclerView()
            }
        }
    }

    private fun setupRecyclerView() {
        mFeedRecyclerView.adapter = mFeedAdapter
        repeat(10) {
            mFeedAdapter.add("")
        }
        mStoryRecyclerView.adapter = mStoryAdapter
        repeat(10) {
            mStoryAdapter.add("")
        }

    }

}