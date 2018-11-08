package com.uni7corn.utheme.factory

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import com.uni7corn.utheme.widget.UTextView

class ThemeFactory : LayoutInflater.Factory2 {

    constructor() {
        Log.e(TAG, "-------->: hello")
    }

    constructor(name: String?) : this() {
        Log.e(TAG, ": -----name=$name")
    }

    companion object {
        private val TAG = ThemeFactory::class.java.simpleName
    }

    init {
        Log.e(TAG, "init")
    }

    override fun onCreateView(parent: View?, name: String?, context: Context, attrs: AttributeSet?): View? {
        Log.e(TAG, "onCreateView: -----2--->name=$name")
        when (name) {
            "TextView" -> {
                var styleAttribute = 0

                for (index in 0 until attrs?.attributeCount!!) {
                    val attributeName = attrs.getAttributeName(index)
                    val attributeValue = attrs.getAttributeValue(index)
                    val nameResource = attrs.getAttributeResourceValue(index, 0)
                    styleAttribute = attrs.styleAttribute

                    //val resourceName = context.resources.getResourceName(nameResource)
                    Log.e(TAG, "--------->: attributeName=$attributeName  attributeValue=$attributeValue  nameResource=$nameResource   styleAttribute=$styleAttribute")
                    //Log.e(TAG, "--------->: resourceName=$resourceName")

                    //val attrResName = resourceName.split("/")[1]

                    //Log.e(TAG, "onCreateView: --------------->attrResName=$attrResName")
                    // break
                }

                return UTextView(context, attrs, styleAttribute)
            }
        }
        return null

    }

    override fun onCreateView(name: String?, context: Context?, attrs: AttributeSet?): View? {
        Log.e(TAG, "onCreateView: --------1---->name=$name")
        return null
    }

}