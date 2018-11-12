package com.javiermasero.domain.model

data class Page(val page: Integer,
                val totalResults: Integer,
                val totalPages: Integer,
                val resultFilm: List<Film>)