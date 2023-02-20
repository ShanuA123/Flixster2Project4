package com.example.flixster2project4

import android.support.annotation.Keep
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

//
//@Keep
//@Serializable
//data class SearchResponse(
//    @SerialName("response")
//    val response: BaseResponse?
//)

@Keep
@Serializable
data class SearchResponse(
    @SerialName("results")
    val results: List<TopPeople>?
)

@Keep
@Serializable
data class TopPeople(
    @SerialName("name")
    val personName: String?,

    @SerialName("profile_path")
    val personImage: String?,

    // Known_for worked when it was List<KnownFor> ?
    @SerialName("known_for")
    val knownFor: List<KnownFor>?,

): java.io.Serializable {
    val bestKnownFor = knownFor?.get(0)
    val imageUrl = "https://image.tmdb.org/t/p/w500/${personImage}"
}

@Keep
@Serializable
data class KnownFor(
    @SerialName("poster_path")
    var movieImage: String?,

    @SerialName("overview")
    val movieDesc: String?,

    @SerialName("title")
    var movieTitle: String? = null,

): java.io.Serializable{
    val posterUrl = "https://image.tmdb.org/t/p/w500/${movieImage}"
}

