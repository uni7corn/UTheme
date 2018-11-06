package com.uni7corn.utheme

import android.os.Bundle
import android.support.v4.view.LayoutInflaterCompat
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.view.ViewGroup
import com.uni7corn.utheme.callback.ITheme
import com.uni7corn.utheme.factory.ThemeFactory
import kotlinx.android.synthetic.main.activity_main.*

open class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onClick(v: View?) {

    }

    companion object {
        private val TAG = MainActivity::class.java.simpleName
    }

    private var themeSuffix = "day"

    override fun onCreate(savedInstanceState: Bundle?) {
        LayoutInflaterCompat.setFactory2(layoutInflater,
                ThemeFactory("wo shi da qi")
        )
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button.setOnClickListener {
            val decorView = window.decorView
            themeSuffix = if (themeSuffix == "day") {
                "night"
            } else {
                "day"
            }
            Log.e(TAG, "onCreate: -------->themeSuffix=$themeSuffix")
            updateTheme(themeSuffix, decorView)
        }

        textView.setOnClickListener(this)
    }

    private fun updateTheme(themeSuffix: String, decorView: View) {
        if (decorView is ITheme) {
            decorView.updateTheme(themeSuffix)
        }
        checkViewGroup(themeSuffix, decorView)
    }

    private fun checkViewGroup(themeSuffix: String, decorView: View) {
        if (decorView is ViewGroup) {
            val count = decorView.childCount
            for (i in 0 until count) {
                updateTheme(themeSuffix, decorView.getChildAt(i))
            }
        }
    }

}
