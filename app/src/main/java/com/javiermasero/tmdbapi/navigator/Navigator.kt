package com.javiermasero.tmdbapi.navigator

import android.content.Context
import android.content.Intent
import com.javiermasero.tmdbapi.presenter.DetailsPresenter
import com.javiermasero.tmdbapi.view.activity.RootActivity
import com.javiermasero.tmdbapi.view.activity.SecondActivity

/**
 * Navigator.
 */
fun navigateToSecondActivity(context: RootActivity<*>) {
    context.startActivity(Intent(context, SecondActivity::class.java))
    context.finish()
}