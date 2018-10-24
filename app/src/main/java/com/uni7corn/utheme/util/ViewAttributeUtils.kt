package com.uni7corn.utheme.util

import android.content.Context
import android.util.AttributeSet

object ViewAttributeUtils {

    @JvmStatic
    fun getResourceName(context: Context, attr: AttributeSet, paramInt: Int): String? {
        val count = attr.attributeCount
        for (index in 0 until count) {
            if (attr.getAttributeNameResource(index) == paramInt) {
                val nameResource = attr.getAttributeResourceValue(index, 0)
                return context.resources.getResourceName(nameResource).split("/".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()[1]
            }
        }
        return null
    }



}