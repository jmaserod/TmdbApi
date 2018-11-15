package com.javiermasero.data.repository

import com.javiermasero.data.datasource.NetworkDataSource
import com.javiermasero.domain.model.Film
import com.javiermasero.domain.repository.FilmRepository
import io.reactivex.Single

class TmdbFilmRepository(private val network: NetworkDataSource) : FilmRepository {
    override fun getFilm(): Single<Film> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}