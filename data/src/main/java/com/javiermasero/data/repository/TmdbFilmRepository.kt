package com.javiermasero.data.repository

import com.javiermasero.data.datasource.NetworkDataSource

import com.javiermasero.domain.model.Film
import com.javiermasero.domain.model.Page

import com.javiermasero.domain.repository.FilmRepository
import io.reactivex.Single


class TmdbFilmRepository(private val network: NetworkDataSource) : FilmRepository {
    override fun getFilm(filmId: Int, apikey: String, language: String): Single<Film> = network.getFilm(filmId = filmId, apikey = apikey, language = language)
    //override fun getFilm(id : Int): Single<Film> = network.getFilm(id = id)
}