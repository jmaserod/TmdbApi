package com.javiermasero.tmdbapi.view.activity

import android.support.v7.widget.RecyclerView
import android.view.View
import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.bind
import com.github.salomonbrys.kodein.instance
import com.github.salomonbrys.kodein.provider
import com.javiermasero.domain.model.Film
import com.javiermasero.tmdbapi.R
import com.javiermasero.tmdbapi.presenter.MainPresenter
import com.javiermasero.tmdbapi.presenter.Presenter
import com.javiermasero.tmdbapi.view.adapter.FilmAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.view_progress.*

class MainActivity : RootActivity<MainPresenter.View>(), MainPresenter.View {
    override val progress: View by lazy { progressView }

    override val presenter: Presenter<MainPresenter.View> by instance()

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

    private val filmsAdapter = FilmAdapter()

    override fun initializeUI() {
        TODO("Initialize recycler view with adapter here")


    }


    override fun registerListeners() {

    }

    override fun showFilms(resultFilm: List<Film>) {
        TODO("Add films to adapter here")
        val adapter: FilmAdapter
        adapter.addAll(resultFilm.toMutableList())
    }
}