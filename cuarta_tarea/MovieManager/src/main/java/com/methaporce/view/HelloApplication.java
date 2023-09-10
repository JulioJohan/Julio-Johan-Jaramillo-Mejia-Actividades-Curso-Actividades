package com.methaporce.view;


import com.methaporce.model.Movie;
import com.methaporce.model.MovieManager;

import java.util.List;


public class HelloApplication {


    public static void main(String[] args) {
//        Creando Peliculas

        Movie myHeroAcademia = new Movie(1,"My Hero Academia: Two Heroes",true);
        Movie jujutsuKaisenCero = new Movie(2,"Jujutsu Kaisen Cero",false);
        Movie theBatman = new Movie(3,"The Batman",true);

//        Agregando peliculas
        MovieManager movieManager = new MovieManager();
        movieManager.listMovies.add(myHeroAcademia);
        movieManager.listMovies.add(jujutsuKaisenCero);
        movieManager.listMovies.add(theBatman);
//      Cambiando el ID
        jujutsuKaisenCero.setId(4);
//        Agregar pelicula
        movieManager.addMovie(jujutsuKaisenCero);
        movieManager.deleteMovie(4);
//        Checar el tamaño de las listas
        System.out.println("Tamanio"+movieManager.listMovies.size());
        movieManager.setMovieAvailable(2);
//        mostrar las películas disponibles
        List<Movie> moviesAvailable = movieManager.getMoviesAvailable();
        moviesAvailable.forEach(movie -> {
            System.out.println("Nombre:"+ movie.getName());
            System.out.println("Disponibles:"+ movie.getAvailable());
        });
        //        mostrar las películas no disponibles
//        List<Movie> moviesNotAvailable = movieManager.getMoviesNotAvailable();
//        moviesNotAvailable.forEach(movie -> {
////            System.out.println("Nombre:"+ movie.getName());
////            System.out.println("Disponibles:"+ movie.getAvailable());
//        });
//        marca una película como disponible según el ID especificado.





    }
}