package com.example.tmdbclient.data.repository.tvshow.datasourceimpl

import com.example.tmdbclient.data.model.movie.Movie
import com.example.tmdbclient.data.model.tvshow.TVShow
import com.example.tmdbclient.data.repository.movie.datasource.MovieCacheDataSource
import com.example.tmdbclient.data.repository.tvshow.datasource.TVShowCacheDataSource

class TVShowCacheDataSourceImpl: TVShowCacheDataSource {
    private var tvShowList = ArrayList<TVShow>()
    override suspend fun getTVShowsFromCache(): List<TVShow> {
        return tvShowList
    }

    override suspend fun saveTVShowsToCache(tvShows: List<TVShow>) {
        tvShowList.clear()
        tvShowList = ArrayList(tvShows)
    }
}