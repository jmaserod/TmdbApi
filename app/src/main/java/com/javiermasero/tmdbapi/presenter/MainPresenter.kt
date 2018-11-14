package com.javiermasero.tmdbapi.presenter

import com.javiermasero.tmdbapi.error.ErrorHandler


class MainPresenter(override val errorHandler: com.javiermasero.tmdbapi.error.ErrorHandler, view: MainPresenter.View) : Presenter<MainPresenter.View>(errorHandler, view) {


    override fun initialize() {}

    override fun resume() {}

    override fun stop() {}

    override fun destroy() {
        // Nothing to do yet
    }

    interface View : Presenter.View {

        fun navigateShowList()

    }

}