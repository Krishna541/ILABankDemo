package com.ilabank

import android.app.Application

class MyILAApp : Application() {

    var context: MyILAApp? = null
    private val TAG: String = MyILAApp::class.java.simpleName

    override fun onCreate() {
        super.onCreate()
        context = this
    }


}