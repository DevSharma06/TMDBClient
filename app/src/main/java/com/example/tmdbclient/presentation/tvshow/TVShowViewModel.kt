package com.example.tmdbclient.presentation.tvshow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.tmdbclient.domain.usecase.GetTVShowUseCase
import com.example.tmdbclient.domain.usecase.UpdateTVShowUseCase

class TVShowViewModel(
    private val getTVShowUseCase: GetTVShowUseCase,
    private val updateTVShowUseCase: UpdateTVShowUseCase
) : ViewModel() {

    fun getTVShows() = liveData {
        val tvShowList = getTVShowUseCase.execute()
        emit(tvShowList)
    }

    fun updateTVShows() = liveData {
        val tvShowList = updateTVShowUseCase.execute()
        emit(tvShowList)
    }
}