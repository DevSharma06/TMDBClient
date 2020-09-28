package com.example.tmdbclient.presentation.di.core

import com.example.tmdbclient.data.repository.artist.datasource.ArtistCacheDataSource
import com.example.tmdbclient.data.repository.artist.datasourceimpl.ArtistCacheDataSourceImpl
import com.example.tmdbclient.data.repository.movie.datasource.MovieCacheDataSource
import com.example.tmdbclient.data.repository.movie.datasourceimpl.MovieCacheDataSourceImpl
import com.example.tmdbclient.data.repository.tvshow.datasource.TVShowCacheDataSource
import com.example.tmdbclient.data.repository.tvshow.datasourceimpl.TVShowCacheDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheDataModule {

    @Singleton
    @Provides
    fun provideMovieCacheDataSource(): MovieCacheDataSource {
        return  MovieCacheDataSourceImpl()
    }

    @Singleton
    @Provides
    fun provideTVShowCacheDataSource(): TVShowCacheDataSource {
        return  TVShowCacheDataSourceImpl()
    }

    @Singleton
    @Provides
    fun provideArtistCacheDataSource(): ArtistCacheDataSource {
        return  ArtistCacheDataSourceImpl()
    }
}