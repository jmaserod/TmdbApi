package com.javiermasero.domain.interactor

import com.javiermasero.domain.executor.Executor
import com.javiermasero.domain.model.Film
import com.javiermasero.domain.model.Page
import com.javiermasero.domain.repository.FilmRepository
import com.javiermasero.domain.repository.PageRepository

class GetFilmDetailsUseCase (private val repository: FilmRepository, executor: Executor) : SingleInteractor<Film>(executor = executor) {

    fun execute(onSuccess: (Film) -> Unit, onError: (Throwable) -> Unit) {
        super.execute(onSuccess, onError, repository.getFilm())
    }
}