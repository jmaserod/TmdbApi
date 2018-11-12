package com.javiermasero.tmdbapi.model

import com.javiermasero.domain.model.Film

data class PageView (val page: Int,
    val totalResults: Int,
    val totalPages: Int,
    val resultFilm: List<Film>){

}