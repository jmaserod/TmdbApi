package com.javiermasero.tmdbapi.error

/**
 * ErrorHandler.
 */
interface ErrorHandler {
    fun convert(e: Exception): String
}