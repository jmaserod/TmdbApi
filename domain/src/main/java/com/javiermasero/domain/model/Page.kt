package com.javiermasero.domain.model

data class Page(val page: Int,
                val totalResults: Int,
                val totalPages: Int,
                val resultFilm: List<Film>)