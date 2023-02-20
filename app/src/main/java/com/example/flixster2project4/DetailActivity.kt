package com.example.flixster2project4

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners

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

        personName.text = "Name: "+person.personName
        movieTitle.text = "Known For: "+person.bestKnownFor?.movieTitle
        movieDesc.text = person.bestKnownFor?.movieDesc

        Glide.with(this)
            .load(person.bestKnownFor?.posterUrl)
            .transform(RoundedCorners(100))
            .into(movieImage)
    }
}