package com.javiermasero.tmdbapi.di

import android.content.Context
import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.bind
import com.github.salomonbrys.kodein.instance
import com.github.salomonbrys.kodein.singleton
import com.javiermasero.data.api.ApiService
import com.javiermasero.data.api.createService
import com.javiermasero.domain.executor.Executor
import com.javiermasero.domain.interactor.GetFilmsUseCase
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


}