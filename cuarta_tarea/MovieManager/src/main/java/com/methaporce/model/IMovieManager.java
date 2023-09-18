package com.methaporce.model;

import java.util.List;

public interface IMovieManager {

    void addMovie(Movie movie);

    void deleteMovie(Integer id);

    List<Movie> getMovies();

    List<Movie> getMoviesAvailable();

    List<Movie> getMoviesNotAvailable();

    void setMovieAvailable(Integer id);

}
