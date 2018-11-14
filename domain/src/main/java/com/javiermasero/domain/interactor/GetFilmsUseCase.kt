package com.javiermasero.domain.interactor;

import com.javiermasero.domain.executor.Executor
import com.javiermasero.domain.model.Page
import com.javiermasero.domain.repository.PageRepository

/**
 * GetFilmsUseCase
 */
class GetFilmsUseCase(private val repository: PageRepository, executor: Executor) : SingleInteractor<Page>(executor = executor) {

    fun execute(onSuccess: (Page) -> Unit, onError: (Throwable) -> Unit) {
        super.execute(onSuccess, onError, repository.getPage())
    }
}