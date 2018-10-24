package com.uni7corn.utheme

import android.os.Bundle
import android.support.v4.view.LayoutInflaterCompat
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.ViewGroup
import com.uni7corn.utheme.callback.ITheme
import com.uni7corn.utheme.factory.ThemeFactory
import kotlinx.android.synthetic.main.activity_main.*

open class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        LayoutInflaterCompat.setFactory2(layoutInflater,
                ThemeFactory("wo shi da qi")
        )
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button.setOnClickListener {
            val decorView = window.decorView
            updateTheme(decorView)
        }
    }

    private fun updateTheme(decorView: View) {
        if (decorView is ITheme) {
            decorView.updateTheme("night")
        }
        checkViewGroup(decorView)
    }

    private fun checkViewGroup(decorView: View) {
        if (decorView is ViewGroup) {
            val count = decorView.childCount
            for (i in 0 until count) {
                updateTheme(decorView.getChildAt(i))
            }
        }
    }

}
