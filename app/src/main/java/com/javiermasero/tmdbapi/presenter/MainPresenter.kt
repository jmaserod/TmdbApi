package com.javiermasero.tmdbapi.presenter

import com.javiermasero.domain.interactor.GetFilmDetailsUseCase
import com.javiermasero.domain.interactor.GetFilmsUseCase
import com.javiermasero.domain.model.Film
import com.javiermasero.tmdbapi.error.ErrorHandler


class MainPresenter(private val getFilmsUseCase: GetFilmsUseCase,/*private val getFilmDetailsUseCase: GetFilmDetailsUseCase,*/
                    errorHandler: ErrorHandler,
                    view: MainPresenter.View)
    : Presenter<MainPresenter.View>(errorHandler, view) {


    override fun initialize() {
        getFilmsUseCase.execute(
                apikey = "c231855877723e26e1da9c71feb1ba02",
                language = "en-US",
                page = 1,
                onSuccess = {
                    view.showFilms(it.resultFilm)
                    view.hideProgress()
                },
                onError = onError { view.showError(it) }
        )

        getFilmDetailsUseCase.execute(
                onSuccess = {
                    view.addFilm(it.resultFilm, id = 1)
                    view.hideProgress()
                },
                onError = onError { view.showError(it) }
        )
    }

    override fun resume() {}

    override fun stop() {}

    override fun destroy() {
        getFilmsUseCase.clear()
        //getFilmDetailsUseCase.clear()
    }

    interface View : Presenter.View {
        fun showFilms(resultFilm: List<Film>)
        fun addFilm(resultFilm: List<Film>, id: Int)
    }

}