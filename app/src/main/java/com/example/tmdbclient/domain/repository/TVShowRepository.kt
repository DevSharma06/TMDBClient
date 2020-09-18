package com.example.tmdbclient.domain.repository

import com.example.tmdbclient.data.model.movie.Movie
import com.example.tmdbclient.data.model.tvshow.TVShow

interface TVShowRepository {
    suspend fun getTVShows(): List<TVShow>?
    suspend fun updateTVShows(): List<TVShow>?
}