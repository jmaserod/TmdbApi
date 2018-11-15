package com.javiermasero.data.datasource

import com.javiermasero.data.api.ApiService
import com.javiermasero.domain.model.Film

import com.javiermasero.domain.model.Page
import io.reactivex.Single

class DataSourcePage(private val apiService : ApiService): NetworkDataSource{
    override fun getPage(page: Int, totalResults: Int, totalPages: Int, resultFilm: List<Film>): Single<Page> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}