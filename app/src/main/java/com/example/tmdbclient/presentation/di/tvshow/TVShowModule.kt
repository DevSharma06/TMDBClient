package com.example.tmdbclient.presentation.di.tvshow

import com.example.tmdbclient.domain.usecase.GetTVShowUseCase
import com.example.tmdbclient.domain.usecase.UpdateTVShowUseCase
import com.example.tmdbclient.presentation.tvshow.TVShowViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class TVShowModule {
    @TVShowScope
    @Provides
    fun provideTVShowViewModelFactory(
        getTVShowUseCase: GetTVShowUseCase,
        updateTVShowUseCase: UpdateTVShowUseCase
    ): TVShowViewModelFactory {
        return TVShowViewModelFactory(
            getTVShowUseCase,
            updateTVShowUseCase
        )
    }

}