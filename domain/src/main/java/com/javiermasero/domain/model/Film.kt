package com.javiermasero.domain.model



data class Film(val id: Int, val  title: String,
                val description: String, val image: String, val average: Double,
                val count: Int, val backdrop: String, val adult: Boolean, val date: String)