package com.example.testproject.data.mapper

import com.example.testproject.data.database.json.model.MovieDbModel
import com.example.testproject.data.network.json.model.MovieDto
import com.example.testproject.domain.repository.json.pojo.Movie
import javax.inject.Inject

class GameInfoMapper @Inject constructor() {

    fun mapDtoToDbModelMovie(movieDto: MovieDto) = MovieDbModel(
        id = movieDto.id,
        voteCount = movieDto.voteCount,
        title = movieDto.title,
        originalTitle = movieDto.originalTitle,
        overview = movieDto.overview,
        posterPath = movieDto.posterPath,
        backdropPath = movieDto.backdropPath,
        releaseDate = movieDto.releaseDate
    )

    fun mapDbModelToMovie(movieDbModel: MovieDbModel) = Movie(
        id = movieDbModel.id,
        voteCount = movieDbModel.voteCount,
        title = movieDbModel.title,
        originalTitle = movieDbModel.originalTitle,
        overview = movieDbModel.overview,
        posterPath = movieDbModel.posterPath,
        backdropPath = movieDbModel.backdropPath,
        releaseDate = movieDbModel.releaseDate
    )

}