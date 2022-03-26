package com.example.testproject.data.network.json.model

import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class MovieDto(
    @SerializedName("id")
    @Expose
    var id: Int,

    @SerializedName("vote_count")
    @Expose
    val voteCount: Int,

    @SerializedName("title")
    @Expose
    val title: String,

    @SerializedName("original_title")
    @Expose
    val originalTitle: String,

    @SerializedName("overview")
    @Expose
    val overview: String,

    @SerializedName("poster_path")
    @Expose
    val posterPath: String,

    @SerializedName("backdrop_path")
    @Expose
    val backdropPath: String,

    @SerializedName("release_date")
    @Expose
    val releaseDate: String
)