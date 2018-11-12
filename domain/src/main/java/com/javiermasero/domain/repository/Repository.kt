package com.javiermasero.domain.repository

import com.javiermasero.domain.model.Film
import com.javiermasero.domain.model.Page
import io.reactivex.Flowable
import io.reactivex.Single

/**
 * Repository.
 */

interface FilmRepository {
    fun getFilm(): Single<Film>
}

interface PageRepository{
    fun getPage(): Single<Page>
}