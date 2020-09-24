package com.example.tmdbclient.data.repository.tvshow.datasourceimpl

import com.example.tmdbclient.data.api.TMDBService
import com.example.tmdbclient.data.model.movie.MovieList
import com.example.tmdbclient.data.model.tvshow.TVShowList
import com.example.tmdbclient.data.repository.movie.datasource.MovieRemoteDataSource
import com.example.tmdbclient.data.repository.tvshow.datasource.TVShowRemoteDataSource
import retrofit2.Response

class TVShowRemoteDataSourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey:String
    ) : TVShowRemoteDataSource {
    override suspend fun getTVShows(): Response<TVShowList> = tmdbService.getPopularTVShows(apiKey)
}