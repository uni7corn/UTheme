package com.uni7corn.utheme.delegate

import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.StateListDrawable
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.uni7corn.utheme.util.AttrTextUtils

class ThemeDelegate {

    companion object {

        @JvmStatic
        fun updateBackgroundTheme(attrBgDrawable: String?, view: View, themeSuffix: String) {
            attrBgDrawable?.let {
                val background = view.background
                val backgroundDrawable = if (background is ColorDrawable) {
                    val identifierColor = view.resources.getIdentifier(AttrTextUtils.splitText(it, themeSuffix), "color", view.context.packageName)
                    if (identifierColor <= 0x0) return
                    val colorStateList = view.resources.getColor(identifierColor)
                    ColorDrawable(colorStateList)
                } else {
                    val identifierDrawable = view.resources.getIdentifier(AttrTextUtils.splitText(it, themeSuffix), "drawable", view.context.packageName)
                    if (identifierDrawable <= 0x0) return
                    val d = view.resources.getDrawable(identifierDrawable)
                    val sld: StateListDrawable = StateListDrawable().apply {
                        addState(view.drawableState, d)
                    }
                    sld
                }
                view.background = backgroundDrawable
            }
        }

        @JvmStatic
        fun updateTextTheme(attrTextColor: String?, view: TextView, themeSuffix: String) {
            attrTextColor?.let {
                val identifierColor = view.resources.getIdentifier(AttrTextUtils.splitText(it, themeSuffix), "color", view.context.packageName)
                if (identifierColor <= 0x0) return
                val colorStateList = view.resources.getColorStateList(identifierColor)
                // val colorStateList = ColorStateList.valueOf(color)
                view.setTextColor(colorStateList)
            }
        }

        @JvmStatic
        fun updateTextHintTheme(attrTextColor: String?, view: TextView, themeSuffix: String) {
            attrTextColor?.let {
                val identifierColor = view.resources.getIdentifier(AttrTextUtils.splitText(it, themeSuffix), "color", view.context.packageName)
                if (identifierColor <= 0x0) return
                val colorStateList = view.resources.getColorStateList(identifierColor)
                // val colorStateList = ColorStateList.valueOf(color)
                view.setHintTextColor(colorStateList)
            }
        }

        @JvmStatic
        fun updateSrcTheme(attrDrawable: String?, view: ImageView, themeSuffix: String) {
            attrDrawable?.let {
                val backgroundDrawable = if (view.drawable is ColorDrawable) {
                    val identifierColor = view.resources.getIdentifier(AttrTextUtils.splitText(it, themeSuffix), "color", view.context.packageName)
                    if (identifierColor <= 0x0) return
                    val colorStateList = view.resources.getColor(identifierColor)
                    ColorDrawable(colorStateList)
                } else {
                    val identifierDrawable = view.resources.getIdentifier(AttrTextUtils.splitText(it, themeSuffix), "drawable", view.context.packageName)
                    if (identifierDrawable <= 0x0) return
                    val d = view.resources.getDrawable(identifierDrawable)
                    val sld: StateListDrawable = StateListDrawable().apply {
                        addState(view.drawableState, d)
                    }
                    sld
                }
                view.setImageDrawable(backgroundDrawable)
            }
        }
    }
}