package com.uni7corn.utheme.widget

import android.content.Context
import android.support.v7.widget.AppCompatTextView
import android.util.AttributeSet
import android.util.Log
import android.view.View
import com.uni7corn.utheme.R
import com.uni7corn.utheme.callback.ITheme
import com.uni7corn.utheme.util.ViewAttributeUtil

@Suppress("DEPRECATION")
class UTextView : AppCompatTextView, ITheme {

    companion object {

        private val TAG: String = UTextView::class.java.simpleName

    }

    private var attrBgDrawable: String? = null
    private var attrTextColor: String? = null

    constructor(context: Context) : this(context, null)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        attrBgDrawable = ViewAttributeUtil.getResourceName(attrs, android.R.attr.background)
        attrTextColor = ViewAttributeUtil.getResourceName(attrs, android.R.attr.textColor)

        resources.getIdentifier(attrTextColor, "color", "schemas.android.com")
        Log.e(TAG, "---------->: attrBgDrawable=$attrBgDrawable    attrTextColor=$attrTextColor")
    }

    override fun getView(): View {
        return this
    }

    override fun updateTheme(themeSuffix: String) {
        attrTextColor = if (attrTextColor?.contains("day")!!) {
            attrTextColor?.replace("day", themeSuffix)
        } else {
            attrTextColor?.replace("themeSuffix", "day")
        }

        val identifierColor = resources.getIdentifier(attrTextColor, "color", context.packageName)

        R.color.b1_color_night

        val color = resources.getColor(identifierColor)
        setTextColor(color)
    }
}