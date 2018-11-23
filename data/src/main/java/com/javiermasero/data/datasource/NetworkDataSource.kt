package com.javiermasero.data.datasource


import com.javiermasero.domain.model.Film
import com.javiermasero.domain.model.Page
import io.reactivex.Single

interface NetworkDataSource {
    fun getPage(apikey: String,language: String, page: Int): Single<Page>


}