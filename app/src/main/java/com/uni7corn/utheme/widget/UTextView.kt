@file:Suppress("DEPRECATION")

package com.uni7corn.utheme.widget

import android.content.Context
import android.graphics.drawable.StateListDrawable
import android.support.v7.widget.AppCompatTextView
import android.util.AttributeSet
import android.util.Log
import android.view.View
import com.uni7corn.utheme.R
import com.uni7corn.utheme.callback.ITheme
import com.uni7corn.utheme.callback.IVisible
import com.uni7corn.utheme.util.AttrTextUtils
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
        //resources.getIdentifier(attrTextColor, "color", "schema.android.com")
       // val styleAttribute = attrs.styleAttribute
        context.obtainStyledAttributes(attrs,android.R.attr.style,0,0)
        Log.e(TAG, "---------->: attrBgDrawable=$attrBgDrawable   attrTextColor=$attrTextColor")
    }

    override fun getView(): View {
        return this
    }

    override fun updateTheme(themeSuffix: String) {
        attrTextColor?.let {
            val identifierColor = resources.getIdentifier(AttrTextUtils.splitText(it, themeSuffix), "color", context.packageName)
            if (identifierColor <= 0x0) return
            val colorStateList = resources.getColorStateList(identifierColor)
            // val colorStateList = ColorStateList.valueOf(color)
            setTextColor(colorStateList)
        }

        attrTextHintColor?.let {
            val identifierColor = resources.getIdentifier(AttrTextUtils.splitText(it, themeSuffix), "color", context.packageName)
            if (identifierColor <= 0x0) return
            val colorStateList = resources.getColorStateList(identifierColor)
            //val colorStateList = ColorStateList.valueOf(color)
            setHintTextColor(colorStateList)
        }
        attrBgDrawable?.let {
            val identifierColor = resources.getIdentifier(AttrTextUtils.splitText(it, themeSuffix), "drawable", context.packageName)
            if (identifierColor <= 0x0) return
            val d = resources.getDrawable(identifierColor)
            val sld: StateListDrawable = StateListDrawable().apply {
                addState(drawableState, d)
            }
            setBackgroundDrawable(sld)
        }
    }

    override fun hide() {
        visibility = View.GONE
    }

    override fun show() {
        visibility = View.VISIBLE
    }
}