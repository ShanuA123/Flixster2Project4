package com.example.flixster2project4

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

private const val TAG = "DetailActivity"

class DetailActivity : AppCompatActivity() {
    private lateinit var movieImage: ImageView
    private lateinit var personName: TextView
    private lateinit var movieTitle: TextView
    private lateinit var movieDesc: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)


        movieImage = findViewById(R.id.iv_movieImage)
        personName = findViewById(R.id.tv_personName)
        movieTitle = findViewById(R.id.tv_movieTitle)
        movieDesc = findViewById(R.id.tv_movieDesc)

        val person = intent.getSerializableExtra(PERSON_EXTRA) as TopPeople

        personName.text = person.personName
        movieTitle.text = person.knownFor?.movieTitle
        movieDesc.text = person.knownFor?.movieDesc
//
//        Glide.with(this)
//            .load("https://image.tmdb.org/t/p/w500/"+person.knownFor?.get(0)?movieImage)
//            .into(movieImage)
    }
}