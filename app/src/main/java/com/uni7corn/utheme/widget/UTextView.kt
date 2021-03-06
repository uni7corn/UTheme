@file:Suppress("DEPRECATION")

package com.uni7corn.utheme.widget

import android.content.Context
import android.support.v7.widget.AppCompatTextView
import android.util.AttributeSet
import android.util.Log
import android.view.View
import com.uni7corn.utheme.callback.ITheme
import com.uni7corn.utheme.callback.IVisible
import com.uni7corn.utheme.delegate.ThemeDelegate
import com.uni7corn.utheme.util.ViewAttributeUtil

class UTextView : AppCompatTextView, ITheme, IVisible {

    companion object {

        private val TAG: String = UTextView::class.java.simpleName

    }

    private var attrBgDrawable: String? = null
    private var attrTextColor: String? = null
    private var attrTextHintColor: String? = null

    constructor(context: Context) : this(context, null)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        attrBgDrawable = ViewAttributeUtil.getResourceName(attrs, android.R.attr.background)
        attrTextColor = ViewAttributeUtil.getResourceName(attrs, android.R.attr.textColor)
        attrTextHintColor = ViewAttributeUtil.getResourceName(attrs, android.R.attr.textColorHint)
        Log.e(TAG, "---------->: attrBgDrawable=$attrBgDrawable   attrTextColor=$attrTextColor")
    }

    override fun getView(): View {
        return this
    }

    override fun updateTheme(themeSuffix: String) {
        ThemeDelegate.updateTextTheme(attrTextColor, this, themeSuffix)
        ThemeDelegate.updateTextHintTheme(attrTextHintColor, this, themeSuffix)
        ThemeDelegate.updateBackgroundTheme(attrBgDrawable, this, themeSuffix)
    }

    override fun hide() {
        visibility = View.GONE
    }

    override fun show() {
        visibility = View.VISIBLE
    }
}