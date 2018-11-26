package com.javiermasero.tmdbapi.presenter

import com.javiermasero.domain.interactor.GetFilmDetailsUseCase
import com.javiermasero.domain.model.Film

import com.javiermasero.tmdbapi.error.ErrorHandler

class DetailsPresenter(private val getFilmDetailsUseCase: GetFilmDetailsUseCase,
                       errorHandler: ErrorHandler,
                       view: DetailsPresenter.View)
    : Presenter<DetailsPresenter.View>(errorHandler, view) {


    override fun initialize() {
       getFilmDetailsUseCase.execute(
               filmId= view.getFilmId(),
               apikey = "c231855877723e26e1da9c71feb1ba02",
               language = "en-US",
                onSuccess = {
                    view.addFilm(it)
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
        fun addFilm(film : Film)
        fun getFilmId(): Int
    }

}