package com.uni7corn.utheme

import android.app.Application
import android.content.Context

class App : Application() {


    companion object {

        private lateinit var mContext: Context


        @JvmStatic
        fun getAppContext(): Application {
            return mContext as Application
        }

    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)

    }

    override fun onCreate() {
        super.onCreate()
        mContext = this
    }
}