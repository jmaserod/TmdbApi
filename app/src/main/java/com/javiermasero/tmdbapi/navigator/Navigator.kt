package com.javiermasero.tmdbapi.navigator

import android.content.Intent
import com.javiermasero.tmdbapi.view.activity.RootActivity
import com.javiermasero.tmdbapi.view.activity.SecondActivity
import com.javiermasero.tmdbapi.view.activity.SecondActivity.Companion.FILM_ID

/**
 * Navigator.
 */
fun navigateToSecondActivity(context: RootActivity<*>, filmId: Int) {
    val intent = Intent(context, SecondActivity::class.java)

    intent.putExtra(FILM_ID, filmId)

    context.startActivity(intent)
    context.finish()
}