package com.javiermasero.data.mapper

import android.util.Log
import com.javiermasero.data.model.FilmsResponseDto
import com.javiermasero.data.model.Result
import com.javiermasero.domain.model.Film
import com.javiermasero.domain.model.Page

fun FilmsResponseDto.toModel(): Page = Page(
        page = this.page,
        totalPages = this.total_pages,
        totalResults = this.total_results,
        resultFilm = this.results.map { result -> result.toModel() }
)

fun Result.toModel(): Film = Film(
        id = this.id,
        description = this.overview,
        title = this.title,
        image = this.poster_path,
        average = this.vote_average,
        count = this.vote_count,
        backdrop = this.backdrop_path,
        adult = this.adult,
        date =  this.release_date
)
fun FilmsResponseDto.hello() {
    val films = mutableListOf<Film>()
    this.results.forEach { result ->
        films.add(result.toModel())
    }
}