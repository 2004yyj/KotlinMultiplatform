package com.example.kmmtest.android

import android.app.Application
import com.example.kmmtest.di.initAndroidDependencies

class TestApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        initAndroidDependencies()
    }
}