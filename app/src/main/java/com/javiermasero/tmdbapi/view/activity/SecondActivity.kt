package com.javiermasero.tmdbapi.view.activity

import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.bind
import com.github.salomonbrys.kodein.instance
import com.github.salomonbrys.kodein.provider
import com.javiermasero.domain.model.Film
import com.javiermasero.tmdbapi.R
import com.javiermasero.tmdbapi.navigator.navigateToSecondActivity
import com.javiermasero.tmdbapi.presenter.DetailsPresenter
import com.javiermasero.tmdbapi.presenter.MainPresenter
import com.javiermasero.tmdbapi.presenter.Presenter
import com.javiermasero.tmdbapi.view.adapter.DetailsAdapter
import com.javiermasero.tmdbapi.view.adapter.FilmAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.view_progress.*

class SecondActivity: RootActivity<DetailsPresenter.View>(), DetailsPresenter.View {


    override val progress: View by lazy { progressView }

    override val presenter: DetailsPresenter by instance()

    override val layoutResourceId: Int = R.layout.activity_main

    override val activityModule: Kodein.Module = Kodein.Module {
        bind<DetailsPresenter>() with provider {
            DetailsPresenter(
                    getFilmDetailsUseCase = instance(),
                    errorHandler = instance(),
                    view = this@SecondActivity
            )
        }
    }


    private val detailsAdapter : DetailsAdapter = DetailsAdapter()

    override fun initializeUI() {
        films.adapter = detailsAdapter
        films.layoutManager = LinearLayoutManager(this)

    }


    override fun registerListeners() {

    }

     override fun addFilm(id: Int) {

    }

}