package com.padc.burgershop.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.padc.burgershop.mvp.presenters.AbstractBasePresenter
import com.padc.burgershop.mvp.presenters.BasePresenter
import com.padc.burgershop.mvp.views.BaseView

abstract class BaseActivity : AppCompatActivity(),BaseView{


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    inline fun <reified T : AbstractBasePresenter<W>, reified W: BaseView>getPresenter(): T{
        val presenter=ViewModelProviders.of(this).get(T::class.java)
        if(this is W)presenter.initPresenter(this)
        return presenter
    }

}