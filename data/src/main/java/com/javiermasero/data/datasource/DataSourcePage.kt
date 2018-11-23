package com.javiermasero.data.datasource

import com.javiermasero.data.api.ApiService
import com.javiermasero.data.mapper.toModel
import com.javiermasero.domain.model.Film

import com.javiermasero.domain.model.Page
import io.reactivex.Single

class DataSourcePage(private val apiService : ApiService): NetworkDataSource{
    override fun getPage(apikey: String, language: String,page: Int): Single<Page> =
        apiService.getPage(apikey = apikey , language = language, page = page)
                .map { response -> response.toModel() }

}