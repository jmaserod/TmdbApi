package com.javiermasero.data.datasource

import com.javiermasero.data.api.ApiService

import com.javiermasero.domain.model.Page
import io.reactivex.Single

class DataSourcePage(private val apiService : ApiService): NetworkDataSource{
    override fun getPage(): Single<Page> = apiService.getPage()

}