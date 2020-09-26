package com.example.tmdbclient.presentation.tvshow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.tmdbclient.domain.usecase.GetTVShowUseCase
import com.example.tmdbclient.domain.usecase.UpdateTVShowUseCase

class TVShowViewModelFactory(
    private val getTVShowUseCase: GetTVShowUseCase,
    private val updateTVShowUseCase: UpdateTVShowUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return TVShowViewModel(getTVShowUseCase, updateTVShowUseCase) as T
    }
}