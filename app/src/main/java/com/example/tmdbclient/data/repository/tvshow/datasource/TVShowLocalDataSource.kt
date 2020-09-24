package com.example.tmdbclient.data.repository.tvshow.datasource

import com.example.tmdbclient.data.model.tvshow.TVShow

interface TVShowLocalDataSource {
    suspend fun getTVShowsFromDB(): List<TVShow>
    suspend fun saveTVShowsToDB(tvShows: List<TVShow>)
    suspend fun clearAll()
}