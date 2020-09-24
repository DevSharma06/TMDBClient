package com.example.tmdbclient.data.repository.tvshow

import android.util.Log
import com.example.tmdbclient.data.model.tvshow.TVShow
import com.example.tmdbclient.data.repository.movie.datasource.MovieCacheDataSource
import com.example.tmdbclient.data.repository.movie.datasource.MovieLocalDataSource
import com.example.tmdbclient.data.repository.movie.datasource.MovieRemoteDataSource
import com.example.tmdbclient.data.repository.tvshow.datasource.TVShowCacheDataSource
import com.example.tmdbclient.data.repository.tvshow.datasource.TVShowLocalDataSource
import com.example.tmdbclient.data.repository.tvshow.datasource.TVShowRemoteDataSource
import com.example.tmdbclient.domain.repository.MovieRepository
import com.example.tmdbclient.domain.repository.TVShowRepository

class TVShowRepositoryImpl(
    private val tvShowRemoteDataSource: TVShowRemoteDataSource,
    private val tvShowCacheDataSource: TVShowCacheDataSource,
    private val tvShowLocalDataSource: TVShowLocalDataSource
) : TVShowRepository {
    override suspend fun getTVShows(): List<TVShow>? {
        return getTVShowsFromCache()
    }

    override suspend fun updateTVShows(): List<TVShow>? {
        val newListOfTVShows = getMoviesFromAPI()
        tvShowLocalDataSource.clearAll()
        tvShowLocalDataSource.saveTVShowsToDB(newListOfTVShows)
        tvShowCacheDataSource.saveTVShowsToCache(newListOfTVShows)
        return newListOfTVShows
    }

    suspend fun getMoviesFromAPI() : List<TVShow> {
        lateinit var tvShowList: List<TVShow>
        try {
            val response = tvShowRemoteDataSource.getTVShows()
            val body = response.body()
            if (body!= null) {
                tvShowList = body.TVShows
            }
        } catch (e: Exception) {
            Log.i("MyTag", e.message.toString())
        }
        return tvShowList
    }

    suspend fun getTVShowsFromDB() : List<TVShow> {
        lateinit var tvShowList: List<TVShow>
        try {
            tvShowList = tvShowLocalDataSource.getTVShowsFromDB()
        } catch (e: Exception) {
            Log.i("MyTag", e.message.toString())
        }
        if (tvShowList.size > 0) {
            return tvShowList
        } else {
            tvShowList = getMoviesFromAPI()
            tvShowLocalDataSource.saveTVShowsToDB(tvShowList)
        }
        return tvShowList
    }

    suspend fun getTVShowsFromCache() : List<TVShow> {
        lateinit var tvShowList: List<TVShow>
        try {
            tvShowList = tvShowCacheDataSource.getTVShowsFromCache()
        } catch (e: Exception) {
            Log.i("MyTag", e.message.toString())
        }
        if (tvShowList.size > 0) {
            return tvShowList
        } else {
            tvShowList = getTVShowsFromDB()
            tvShowCacheDataSource.saveTVShowsToCache(tvShowList)
        }
        return tvShowList
    }
}