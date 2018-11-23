package com.javiermasero.tmdbapi.view.activity


import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.bumptech.glide.Glide
import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.bind
import com.github.salomonbrys.kodein.instance
import com.github.salomonbrys.kodein.provider
import com.javiermasero.domain.model.Film
import com.javiermasero.tmdbapi.R
import com.javiermasero.tmdbapi.navigator.navigateToSecondActivity
import com.javiermasero.tmdbapi.presenter.MainPresenter
import com.javiermasero.tmdbapi.view.adapter.DetailsAdapter
import com.javiermasero.tmdbapi.view.adapter.FilmAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.view_progress.*

class MainActivity : RootActivity<MainPresenter.View>(), MainPresenter.View {


    override val progress: View by lazy { progressView }

    override val presenter: MainPresenter by instance()

    override val layoutResourceId: Int = R.layout.activity_main

    override val activityModule: Kodein.Module = Kodein.Module {
        bind<MainPresenter>() with provider {
            MainPresenter(
                    getFilmsUseCase = instance(),
                    errorHandler = instance(),
                    view = this@MainActivity
            )
        }
    }

    private val filmsAdapter : FilmAdapter = FilmAdapter {

    }

    override fun initializeUI() {
        films.adapter = filmsAdapter
        films.layoutManager = LinearLayoutManager(this)

    }
    fun navigateToSecondActivity() {
        navigateToSecondActivity(this)
    }

    override fun registerListeners() {

    }

    override fun showFilms(resultFilm: List<Film>) {
        filmsAdapter.addAll(resultFilm.toMutableList())
    }
}