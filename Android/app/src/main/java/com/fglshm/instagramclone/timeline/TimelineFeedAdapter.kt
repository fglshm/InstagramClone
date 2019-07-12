package com.fglshm.instagramclone.timeline

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.Context
import android.graphics.Color
import android.text.*
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.view.LayoutInflater
import android.view.View
import com.fglshm.extensions2.setInvisible
import com.fglshm.extensions2.setVisible
import com.fglshm.extensions2.showToastInCenter
import com.fglshm.instagramclone.R
import com.fglshm.instagramclone.common.base.BaseRecyclerAdapter
import com.fglshm.instagramclone.common.viewholder.ItemViewHolder
import kotlinx.android.synthetic.main.popup_feed_more.view.*
import kotlinx.android.synthetic.main.recyclerview_feed_fragment_timeline.view.*


class TimelineFeedAdapter(
    private val mContext: Context
) : BaseRecyclerAdapter<String>() {

    private val cls = TimelineFeedAdapter::class
    override val logTag: String = TimelineFeedAdapter::class.java.simpleName
    override fun getLayout(): Int = R.layout.recyclerview_feed_fragment_timeline

    private val username = "fgl___1"

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.itemView.apply {
            val caption =
                "<b>$username</b> If you’re nervous about speaking English in a new job, don’t try to memorize complicated things. Your coworkers won’t be testing you on your grammar knowledge, and they probably won’t care if you use an impressive vocabulary word."
            txt_caption_feed.maxLines = 2
            txt_caption_feed.text = Html.fromHtml(caption, 0)
            val clickableSpan = object : ClickableSpan() {
                override fun onClick(widget: View) {
                    txt_caption_feed.highlightColor = Color.TRANSPARENT
                    "To Profile Page".showToastInCenter(context)
                }

                override fun updateDrawState(ds: TextPaint) {
                    ds.color = context.getColor(R.color.colorBlack)
                    ds.isUnderlineText = false
                }
            }
            val ss = SpannableString(Html.fromHtml(caption, 0))
            ss.setSpan(clickableSpan, 0, username.length.minus(1), Spanned.SPAN_INCLUSIVE_INCLUSIVE)
            txt_caption_feed.text = ss
            txt_caption_feed.movementMethod = LinkMovementMethod.getInstance()
            txt_caption_feed.post {
                if (txt_caption_feed.lineCount > 2) {
                    txt_more_feed.setVisible()
                } else {
                    txt_more_feed.setInvisible()
                }
            }
            txt_more_feed.setOnClickListener {
                txt_caption_feed.maxLines = Integer.MAX_VALUE
                txt_more_feed.setInvisible()
            }
            txt_caption_feed.setOnClickListener {
                txt_caption_feed.maxLines = Integer.MAX_VALUE
                txt_more_feed.setInvisible()
            }
            img_btn_more_feed.setOnClickListener {
                handleMore(position)
            }
        }
    }

    @SuppressLint("InflateParams")
    private fun handleMore(position: Int) {
        val builder = AlertDialog.Builder(mContext)
        val popupView = LayoutInflater.from(mContext).inflate(R.layout.popup_feed_more, null)
        builder.setView(popupView)
        val dialog = builder.create()
        dialog.show()
        popupView.apply {
            txt_report_feed_more.setOnClickListener { }
            txt_copy_feed_more.setOnClickListener { }
            txt_on_notif_feed_more.setOnClickListener { }
            txt_share_feed_more.setOnClickListener { }
            txt_unfollow_feed_more.setOnClickListener { }
            txt_mute_feed_more.setOnClickListener { }
        }
    }

}