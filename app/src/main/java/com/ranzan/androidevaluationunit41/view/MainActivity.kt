package com.ranzan.androidevaluationunit41.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.ranzan.androidevaluationunit41.R
import com.ranzan.androidevaluationunit41.viewModel.Repo
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var repo: Repo
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        repo = Repo(MainActivity@ this)
        repo.fetchAPI()
        val data = repo.getData(MainActivity@ this)
        data.apply {
            tvName.text=name
            tvEmail.text=email
            tvGender.text=gender
            tvCity.text=city
            tvCountry.text=country
            tvPhone.text=phone
            tvDOB.text=dob
            Glide.with(imgPic).load(pic).into(imgPic)
        }



        nextBtn.setOnClickListener {
            repo.fetchAPI()
        }
    }
}