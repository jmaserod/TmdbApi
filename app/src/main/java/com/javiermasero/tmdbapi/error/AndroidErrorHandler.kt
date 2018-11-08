package com.javiermasero.tmdbapi.error

import android.content.Context
import com.javiermasero.tmdbapi.R

/**
 * AndroidErrorHandler.
 */
class AndroidErrorHandler(val context: Context) : ErrorHandler {
    override fun convert(e: Exception): String =
            when (e) {
                else -> context.getString(R.string.default_error)
            }

}