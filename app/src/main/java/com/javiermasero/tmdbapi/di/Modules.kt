package com.javiermasero.tmdbapi.di

import android.content.Context
import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.bind
import com.github.salomonbrys.kodein.instance
import com.github.salomonbrys.kodein.singleton
import com.javiermasero.data.api.ApiService
import com.javiermasero.data.api.createService
import com.javiermasero.data.constants.BuildType
import com.javiermasero.data.constants.buildType
import com.javiermasero.data.datasource.NetworkDataSource
import com.javiermasero.domain.executor.Executor
import com.javiermasero.tmdbapi.error.ErrorHandler
import com.javiermasero.tmdbapi.error.AndroidErrorHandler
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
    // Add here data dependencies
}

val dataModule = Kodein.Module {
    // Add here data dependencies
/* API SERVICES */
    bind<ApiService>() with singleton {
        createService(ApiService::class.java, ApiService.ENDPOINT)
    }


}