package com.fglshm.instagramclone.timeline

import android.graphics.Color
import android.text.Html
import android.text.SpannableString
import android.text.Spanned
import android.text.TextPaint
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.view.View
import com.fglshm.extensions2.showLogD
import com.fglshm.extensions2.showToastInCenter
import com.fglshm.instagramclone.R
import com.fglshm.instagramclone.base.BaseRecyclerAdapter
import com.fglshm.instagramclone.viewholder.ItemViewHolder
import kotlinx.android.synthetic.main.recyclerview_feed_fragment_timeline.view.*
import kotlin.reflect.KClass

class TimelineFeedAdapter : BaseRecyclerAdapter<String>() {

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
                    txt_caption_feed.text.subSequence(0, username.length).toString().showToastInCenter(context)
                    txt_caption_feed.maxLines = Integer.MAX_VALUE
                }

                override fun updateDrawState(ds: TextPaint) {
                    ds.color = context.getColor(R.color.colorBlack)
                    ds.isUnderlineText = false
                }
            }
            val ss = SpannableString(Html.fromHtml(caption, 0))
            ss.setSpan(clickableSpan, 0, username.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
            txt_caption_feed.text = ss
            txt_caption_feed.movementMethod = LinkMovementMethod.getInstance()
        }
    }

}