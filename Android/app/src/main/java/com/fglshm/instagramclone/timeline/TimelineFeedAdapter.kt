package com.fglshm.instagramclone.timeline

import com.fglshm.instagramclone.R
import com.fglshm.instagramclone.base.BaseRecyclerAdapter
import com.fglshm.instagramclone.viewholder.ItemViewHolder

class TimelineFeedAdapter : BaseRecyclerAdapter<String>() {

    override val logTag: String = TimelineFeedAdapter::class.java.simpleName
    override fun getLayout(): Int = R.layout.recyclerview_feed_fragment_timeline

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {

    }
}