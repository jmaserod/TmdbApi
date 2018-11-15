package com.javiermasero.tmdbapi.di

import android.content.Context
import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.bind
import com.github.salomonbrys.kodein.instance
import com.github.salomonbrys.kodein.singleton
import com.javiermasero.data.api.ApiService
import com.javiermasero.data.api.createService
import com.javiermasero.data.datasource.DataSourcePage
import com.javiermasero.data.datasource.NetworkDataSource
import com.javiermasero.data.repository.TmdbFilmRepository
import com.javiermasero.data.repository.TmdbPageRepository
import com.javiermasero.domain.executor.Executor
import com.javiermasero.domain.interactor.GetFilmsUseCase
import com.javiermasero.domain.repository.FilmRepository
import com.javiermasero.domain.repository.PageRepository
import com.javiermasero.tmdbapi.error.AndroidErrorHandler
import com.javiermasero.tmdbapi.error.ErrorHandler
import com.javiermasero.tmdbapi.executor.RxExecutor

/**
 * Modules
 */
fun appModule(context: Context) = Kodein.Module {
    bind<Context>() with singleton { context }
    bind<Executor>() with singleton { RxExecutor() }
    bind<ErrorHandler>() with singleton { AndroidErrorHandler(context = context) }
}

val domainModule = Kodein.Module {
    bind<GetFilmsUseCase>() with singleton { GetFilmsUseCase(repository = instance(), executor = instance()) }
}

val dataModule = Kodein.Module {

    // TODO("Add repositories and datasources here")

    bind<ApiService>() with singleton {
        createService(ApiService::class.java, ApiService.ENDPOINT)
    }

    /*DATASOURCES*/
    bind<NetworkDataSource>() with singleton { DataSourcePage(apiService = instance()) }

    /*REPOSITORY*/
    bind<PageRepository>() with singleton {TmdbPageRepository(network = instance()) }
    bind<FilmRepository>() with singleton {TmdbFilmRepository(network = instance())}




}