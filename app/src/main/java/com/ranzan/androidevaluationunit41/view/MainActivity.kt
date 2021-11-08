package com.ranzan.androidevaluationunit41.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ranzan.androidevaluationunit41.R
import com.ranzan.androidevaluationunit41.viewModel.Repo

class MainActivity : AppCompatActivity() {
    private lateinit var repo: Repo
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        repo.fetchAPI()
    }
}