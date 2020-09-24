package com.example.tmdbclient.data.repository.tvshow.datasourceimpl

import com.example.tmdbclient.data.db.MovieDao
import com.example.tmdbclient.data.db.TVShowDao
import com.example.tmdbclient.data.model.movie.Movie
import com.example.tmdbclient.data.model.tvshow.TVShow
import com.example.tmdbclient.data.repository.movie.datasource.MovieLocalDataSource
import com.example.tmdbclient.data.repository.tvshow.datasource.TVShowLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TVShowLocalDataSourceImpl(private val tvShowDao: TVShowDao): TVShowLocalDataSource {
    override suspend fun getTVShowsFromDB(): List<TVShow> {
        return tvShowDao.getTVShows()
    }

    override suspend fun saveTVShowsToDB(tvShows: List<TVShow>) {
        CoroutineScope(Dispatchers.IO).launch {
            tvShowDao.saveTVShows(tvShows)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            tvShowDao.deleteAllTVShows()
        }
    }
}