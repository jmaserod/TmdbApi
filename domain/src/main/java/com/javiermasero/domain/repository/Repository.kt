package com.javiermasero.domain.repository

import com.javiermasero.domain.model.Film
import com.javiermasero.domain.model.Page
import io.reactivex.Single

/**
 * Repository.
 */

interface FilmRepository {
    fun getFilm(): Single<Film>
}


// TODO("Implement the repository in the data module")
interface PageRepository {
    fun getPage(): Single<Page>
}