package com.javiermasero.tmdbapi.view.activity

import android.view.View
import android.widget.TextView
import com.github.salomonbrys.kodein.Kodein
import com.javiermasero.tmdbapi.R
import com.javiermasero.tmdbapi.R.id.relativeLayoutElements
import com.javiermasero.tmdbapi.navigator.navigateToShowList

import com.javiermasero.tmdbapi.presenter.MainPresenter
import com.javiermasero.tmdbapi.presenter.Presenter

class MainActivity(override val progress: View, override val presenter: Presenter<MainPresenter.View>, override val layoutResourceId: Int, override val activityModule: Kodein.Module) : RootActivity<MainPresenter.View>(), MainPresenter.View {





    override fun initializeUI() {
        showList()
    }

    override fun registerListeners() {

    }

    fun showList() {
        navigateToShowList()
    }

    override fun navigateShowList() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}