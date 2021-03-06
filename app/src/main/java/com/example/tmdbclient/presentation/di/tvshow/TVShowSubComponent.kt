package com.example.tmdbclient.presentation.di.tvshow

import com.example.tmdbclient.presentation.tvshow.TVShowActivity
import dagger.Subcomponent

@TVShowScope
@Subcomponent(modules = [TVShowModule::class])
interface TVShowSubComponent {
    fun inject(tvShowActivity: TVShowActivity)

    @Subcomponent.Factory
    interface Factory {
        fun create(): TVShowSubComponent
    }
}