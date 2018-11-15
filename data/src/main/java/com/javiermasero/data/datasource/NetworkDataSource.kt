package com.javiermasero.data.datasource


import com.javiermasero.domain.model.Film
import com.javiermasero.domain.model.Page
import io.reactivex.Single

interface NetworkDataSource {
    fun getPage(page: Int, totalResults: Int, totalPages: Int, resultFilm: List<Film>): Single<Page>
}