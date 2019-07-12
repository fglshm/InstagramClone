package com.fglshm.instagramclone.profile

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import com.fglshm.extensions2.screenWidth
import com.fglshm.instagramclone.R
import com.fglshm.instagramclone.common.base.BaseRecyclerAdapter
import com.fglshm.instagramclone.common.viewholder.ItemViewHolder

class ProfileGalleryRecyclerAdapter(
    private val context: Context
) : BaseRecyclerAdapter<String>() {

    override val logTag: String = ProfileGalleryRecyclerAdapter::class.java.simpleName
    override fun getLayout(): Int = R.layout.recyclerview_fragment_profile_gallery

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val screenWidth = (context as AppCompatActivity).screenWidth()
        holder.itemView.apply {
            requestLayout()
            layoutParams.width = screenWidth.div(3)
            layoutParams.height = screenWidth.div(3)
        }
    }

}