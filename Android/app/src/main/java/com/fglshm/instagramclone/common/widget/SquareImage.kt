package com.fglshm.instagramclone.common.widget

import android.content.Context
import android.util.AttributeSet
import android.widget.ImageView

class SquareImage : ImageView {

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val mWidth = measuredWidth
        val mHeight = measuredHeight
        if (mHeight > mWidth) {
            setMeasuredDimension(mWidth, mWidth)
        } else {
            setMeasuredDimension(mHeight, mHeight)
        }
    }
}