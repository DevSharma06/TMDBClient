package com.example.tmdbclient.data.repository.tvshow.datasource

import com.example.tmdbclient.data.model.tvshow.TVShowList
import retrofit2.Response

interface TVShowRemoteDataSource {
    suspend fun getTVShows(): Response<TVShowList>
}