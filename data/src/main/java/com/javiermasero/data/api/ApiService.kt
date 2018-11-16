package com.javiermasero.data.api

import com.javiermasero.data.model.FilmsResponseDto
import com.javiermasero.domain.model.Page
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService{
    companion object {
        val ENDPOINT = "https://api.themoviedb.org/3/movie/"

    }
    @GET("top_rated")
    fun getPage(@Query("api_key") apikey: String, @Query("language") language: String, @Query("page") page: Int): Single<FilmsResponseDto>

    // ?api_key=c231855877723e26e1da9c71feb1ba02&language=en-US&page=1

}
