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
    var personName: String?,

    @SerialName("profile_path")
    var personImage: String?=null,

    // Known_for worked when it was List<KnownFor> ?
    @SerialName("known_for")
    var knownFor: KnownFor?,

): java.io.Serializable

@Keep
@Serializable
data class KnownFor(
    @SerialName("poster_path")
    var movieImage: String?,

    @SerialName("overview")
    var movieDesc: String?,

    @SerialName("original_title")
    var movieTitle: String?,

    @SerialName("release_date")
    var moveRelease: String?,
): java.io.Serializable

