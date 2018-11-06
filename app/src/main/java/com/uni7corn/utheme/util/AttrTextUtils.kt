package com.uni7corn.utheme.util

import android.util.Log

class AttrTextUtils {

    companion object {
        private val TAG = AttrTextUtils::class.java.simpleName
        private const val SPLIT_SEPARATOR = "_"

        /**
         * @attrText 需要替换后缀的资源文件名
         * @newThemeSuffix 被替换的新的资源的文件名后缀
         * @ignoreCase  是否忽略大小写
         */
        @JvmStatic
        @JvmOverloads
        fun splitText(attrText: String, newThemeSuffix: String, ignoreCase: Boolean = false): String {
            val oldThemeSuffix = attrText.split(SPLIT_SEPARATOR.toRegex()).last()
            Log.e(TAG, "--------->oldThemeSuffix=$oldThemeSuffix  newThemeSuffix=$newThemeSuffix")
            return attrText.replace(oldThemeSuffix, newThemeSuffix, ignoreCase)
        }
    }


}