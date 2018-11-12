package com.javiermasero.data.api

import com.javiermasero.domain.model.Page
import io.reactivex.Flowable
import retrofit2.http.GET

interface ApiService{
    companion object {
        val ENDPOINT = "https://api.themoviedb.org/3/movie/top_rated?api_key=c231855877723e26e1da9c71feb1ba02&language=en-US&page=1"

    }
    @GET("top_rated")
    fun getPage(): Flowable<Page>

}
