package com.fglshm.instagramclone.profile.profileedit

import com.fglshm.instagramclone.R
import com.fglshm.instagramclone.common.base.BaseRecyclerAdapter
import com.fglshm.instagramclone.common.viewholder.ItemViewHolder
import kotlinx.android.synthetic.main.recyclerview_profile_edit.view.*

class ProfileEditRecyclerAdapter : BaseRecyclerAdapter<DetailItem>() {

    override val logTag: String = ProfileEditRecyclerAdapter::class.java.simpleName
    override fun getLayout(): Int = R.layout.recyclerview_profile_edit

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = itemList[position]
        holder.itemView.apply {
            txt_label_recyclerview_profile_edit.text = item?.label
            edt_recyclerview_profile_edit.setText(item?.detail)
        }
    }
}