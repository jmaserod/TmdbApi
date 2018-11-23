package com.javiermasero.tmdbapi.view.activity

import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.bind
import com.github.salomonbrys.kodein.instance
import com.github.salomonbrys.kodein.provider
import com.javiermasero.data.constants.Constants.Companion.DEFAULT_INT
import com.javiermasero.tmdbapi.R

import com.javiermasero.tmdbapi.presenter.DetailsPresenter
import com.javiermasero.tmdbapi.view.adapter.DetailsAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.view_progress.*

class SecondActivity : RootActivity<DetailsPresenter.View>(), DetailsPresenter.View {

    companion object {
        const val FILM_ID = "FILM_ID"
    }

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


    private val detailsAdapter: DetailsAdapter = DetailsAdapter()

    override fun initializeUI() {
        films.adapter = detailsAdapter
        films.layoutManager = LinearLayoutManager(this)

    }


    override fun registerListeners() {

    }

    override fun addFilm(id: Int) {


    }

    override fun getFilmId(): Int = intent?.extras?.getInt(FILM_ID) ?: DEFAULT_INT

}