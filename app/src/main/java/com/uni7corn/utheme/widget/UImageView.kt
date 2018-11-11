package com.uni7corn.utheme.widget

import android.content.Context
import android.support.v7.widget.AppCompatImageView
import android.util.AttributeSet
import android.util.Log
import android.view.View
import com.uni7corn.utheme.callback.ITheme
import com.uni7corn.utheme.callback.IVisible
import com.uni7corn.utheme.delegate.ThemeDelegate
import com.uni7corn.utheme.util.ViewAttributeUtil

class UImageView : AppCompatImageView, ITheme, IVisible {

    companion object {
        private val TAG = UImageView::class.java.simpleName
    }

    private var attrBgDrawable: String?
    private var attrSrcDrawable: String?


    constructor(context: Context) : this(context, null)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {

        attrSrcDrawable = ViewAttributeUtil.getResourceName(attrs, android.R.attr.src)
        attrBgDrawable = ViewAttributeUtil.getResourceName(attrs, android.R.attr.background)

        Log.e(TAG, "attrSrcDrawable=$attrSrcDrawable")
    }

    override fun getView(): View {
        return this
    }

    override fun updateTheme(themeSuffix: String) {
        ThemeDelegate.updateSrcTheme(attrSrcDrawable, this, themeSuffix)
        ThemeDelegate.updateBackgroundTheme(attrSrcDrawable, this, themeSuffix)
    }

    override fun hide() {
        visibility = View.GONE
    }

    override fun show() {
        visibility = View.VISIBLE
    }

}