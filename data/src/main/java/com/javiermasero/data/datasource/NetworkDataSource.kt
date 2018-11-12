package com.javiermasero.data.datasource


import com.javiermasero.domain.model.Page
import io.reactivex.Single

interface NetworkDataSource {
    fun getPage(): Single<Page>
}