package com.example.tmdbclient.data.repository.tvshow.datasource

import com.example.tmdbclient.data.model.tvshow.TVShow

interface TVShowCacheDataSource {
    suspend fun getTVShowsFromCache(): List<TVShow>
    suspend fun saveTVShowsToCache(movies: List<TVShow>)
}