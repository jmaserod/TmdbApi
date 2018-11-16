package com.javiermasero.data.mapper

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
        title = this.original_title
)

fun FilmsResponseDto.hello() {
    val films = mutableListOf<Film>()
    this.results.forEach { result ->
        films.add(result.toModel())
    }
}