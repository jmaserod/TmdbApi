package com.javiermasero.data.repository

import com.javiermasero.data.datasource.NetworkDataSource
import com.javiermasero.domain.model.Page
import com.javiermasero.domain.repository.PageRepository
import io.reactivex.Single

class TmdbPageRepository( private val network: NetworkDataSource) : PageRepository {


    override fun getPage(apikey: String, language: String, page: Int): Single<Page> =  network.getPage(apikey = apikey, language = language, page = page)





}