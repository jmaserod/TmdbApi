package com.javiermasero.tmdbapi.presenter

import com.javiermasero.domain.interactor.GetFilmsUseCase
import com.javiermasero.domain.model.Film
import com.javiermasero.tmdbapi.error.ErrorHandler


class MainPresenter(private val getFilmsUseCase: GetFilmsUseCase,
                    errorHandler: ErrorHandler,
                    view: MainPresenter.View)
    : Presenter<MainPresenter.View>(errorHandler, view) {


    override fun initialize() {
        getFilmsUseCase.execute(
                onSuccess = { view.showFilms(it.resultFilm) },
                onError = onError { view.showError(it) }
        )
    }

    override fun resume() {}

    override fun stop() {}

    override fun destroy() {
        getFilmsUseCase.clear()
    }

    interface View : Presenter.View {
        fun showFilms(resultFilm: List<Film>)
    }

}