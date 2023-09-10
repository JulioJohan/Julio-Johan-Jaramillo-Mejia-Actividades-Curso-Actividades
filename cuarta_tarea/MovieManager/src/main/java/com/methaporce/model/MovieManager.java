package com.methaporce.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class MovieManager implements IMovieManager {

    public List<Movie> listMovies = new ArrayList<>();

    // agrega una película la colección.
    @Override
    public void addMovie(Movie movie) {
        listMovies.add(movie);
        System.out.println("La película se agregó correctamente");
    }

    // elimina la película con el id especificado de la colección
    @Override
    public void deleteMovie(Integer id) {
        listMovies.removeIf(movie -> movie.getId().equals(id));
    }

    // devuelve una lista con todas las películas.
    @Override
    public List<Movie> getMovies() {
        return this.listMovies;
    }

   //devuelve una lista con las películas disponibles.
    @Override
    public List<Movie> getMoviesAvailable() {
//        El stream ayuda a facilitarnos para poder filtrar y tener
//        mas iteración
        return listMovies.stream()
                .filter(movie -> movie.getAvailable().equals(true))
                .toList();
    }

    //devuelve una lista con las películas no disponibles.
    @Override
    public List<Movie> getMoviesNotAvailable() {
        return listMovies.stream().filter(movie -> !movie.getAvailable()).toList();
    }


    //marca una película como disponible según el ID especificado
    @Override
    public void setMovieAvailable(Integer id) {

        for (Movie movie:listMovies){
            if (movie.getId().equals(id)){
                movie.setAvailable(true);
                System.out.println("La película ya esta disponible");
            }
        }
//        listMovies.forEach(movie -> {
//            if (!movie.getId().equals(id)){
//                System.out.println("La película no existe");
//                return;
//            }
//           if (movie.getId().equals(id) && movie.getAvailable()){
//               movie.setAvailable(true);
//           }
//        });
    }
}
