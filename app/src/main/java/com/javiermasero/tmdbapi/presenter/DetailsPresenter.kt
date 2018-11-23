package com.javiermasero.tmdbapi.presenter

import com.javiermasero.domain.interactor.GetFilmDetailsUseCase

import com.javiermasero.tmdbapi.error.ErrorHandler

class DetailsPresenter(private val getFilmDetailsUseCase: GetFilmDetailsUseCase,
                       errorHandler: ErrorHandler,
                       view: DetailsPresenter.View)
    : Presenter<DetailsPresenter.View>(errorHandler, view) {


    override fun initialize() {
       getFilmDetailsUseCase.execute(
                id = 1,
                onSuccess = {
                    view.addFilm(id = 1)
                    view.hideProgress()
                },
                onError = onError { view.showError(it) }
        )
    }

    override fun resume() {}

    override fun stop() {}

    override fun destroy() {
        getFilmDetailsUseCase.clear()
    }


    interface View : Presenter.View {
        fun addFilm(id: Int)
        fun getFilmId(): Int
    }

}