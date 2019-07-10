package com.fglshm.instagramclone.drawer

import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.fglshm.instagramclone.R
import com.fglshm.instagramclone.base.BaseFragment
import com.fglshm.instagramclone.base.BaseRecyclerAdapter
import com.fglshm.instagramclone.viewholder.ItemViewHolder
import kotlinx.android.synthetic.main.fragment_drawer.*
import kotlinx.android.synthetic.main.recyclerview_fragment_drawer.view.*

class DrawerFragment : BaseFragment() {

    override val logTag: String = DrawerFragment::class.java.simpleName
    override fun getLayout(): Int = R.layout.fragment_drawer

    private val mRecyclerView by lazy { recycler_fragment_drawer }
    private val mAdapter by lazy { DrawerRecyclerAdapter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        mRecyclerView.apply {
            adapter = mAdapter
            setHasFixedSize(true)
        }
        mAdapter.addAll(drawerItems())
        mRecyclerView.setOnClickListener {
        }
    }

    private fun drawerItems(): List<DrawerItem> = listOf(
        DrawerItem(R.drawable.ic_archive, "Archive"),
        DrawerItem(R.drawable.ic_focus, "Nametag"),
        DrawerItem(R.drawable.ic_list, "Saved"),
        DrawerItem(R.drawable.ic_close_friend, "Close Friends"),
        DrawerItem(R.drawable.ic_add_user, "Discover People"),
        DrawerItem(R.drawable.ic_facebook, "Open Facebook")
    )

    class DrawerRecyclerAdapter : BaseRecyclerAdapter<DrawerItem>() {

        override val logTag: String = DrawerRecyclerAdapter::class.java.simpleName
        override fun getLayout(): Int = R.layout.recyclerview_fragment_drawer

        override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
            val item = itemList[position]
            holder.itemView.apply {
                img_recyclerview_fragment_drawer.setImageResource(item?.res ?: 0)
                txt_recyclerview_fragment_drawer.text = item?.title
                setOnClickListener {
                    Toast.makeText(context, "$position", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    data class DrawerItem(val res: Int, val title: String)

}