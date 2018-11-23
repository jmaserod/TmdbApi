package com.javiermasero.domain.repository

import com.javiermasero.domain.model.Film
import com.javiermasero.domain.model.Page
import io.reactivex.Single

/**
 * Repository.
 */

interface FilmRepository {
    fun getFilm(id: Int): Single<Film>
}
interface PageRepository {
    fun getPage(apikey: String, language: String, page: Int): Single<Page>
}