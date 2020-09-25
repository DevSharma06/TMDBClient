package com.example.tmdbclient.presentation.tvshow

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.tmdbclient.R
import com.example.tmdbclient.databinding.ActivityTVShowBinding

class TVShowActivity : AppCompatActivity() {
    private lateinit var binding : ActivityTVShowBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_t_v_show)
    }
}