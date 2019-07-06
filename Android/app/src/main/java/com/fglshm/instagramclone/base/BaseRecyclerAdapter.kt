package com.fglshm.instagramclone.base

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fglshm.instagramclone.viewholder.ItemViewHolder

abstract class BaseRecyclerAdapter<T> : RecyclerView.Adapter<ItemViewHolder>() {

    abstract val logTag: String
    abstract fun getLayout(): Int

    protected val itemList: MutableList<T?> = mutableListOf()

    override fun getItemCount(): Int = itemList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(getLayout(), parent, false)
        return ItemViewHolder(view)
    }

    fun add(what: T?) {
        itemList.add(what)
    }

    fun addAll(what: List<T?>) {
        itemList.addAll(what)
    }

    fun showLog(message: Any?) {
        Log.d(logTag, message?.toString() ?: "no message")
    }

}