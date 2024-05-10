package service;

import model.Movie;
import model.User;

import java.util.ArrayList;
import java.util.List;

public class MovieService {
    private List<Movie> movies;
    private List<User> users;

    public MovieService() {
        this.movies = new ArrayList<>();
        this.users = new ArrayList<>();
    }

    public void addMovie(Movie movie) {
        movies.add(movie);
    }

    public List<Movie> searchMovies(String keyword) {
        List<Movie> searchResults = new ArrayList<>();
        for (Movie movie : movies) {
            if (movie.getTitle().toLowerCase().contains(keyword.toLowerCase()) ||
                    movie.getCast().toLowerCase().contains(keyword.toLowerCase()) ||
                    movie.getCategory().toLowerCase().contains(keyword.toLowerCase())) {
                searchResults.add(movie);
            }
        }
        return searchResults;
    }

    public List<Movie> getAllMovies() {
        return movies;
    }

    public void registerUser(String email, String name, int age) {
        users.add(new User(email, name, age));
    }

    public List<User> getUsers() {
        return users;
    }


    public void addFavoriteMovie(String userEmail, Movie movie) {
        User user = findUserByEmail(userEmail);
        if (user != null) {
            user.addFavoriteMovie(movie);
        }
    }

    public List<Movie> getFavoriteMovies(String userEmail) {
        User user = findUserByEmail(userEmail);
        if (user != null) {
            return user.getFavoriteMovies();
        }
        return new ArrayList<>();
    }

    private User findUserByEmail(String email) {
        for (User user : users) {
            if (user.getEmail().equals(email)) {
                return user;
            }
        }
        return null;
    }

    public List<Movie> searchFavoriteMovies(String userEmail, String keyword) {
        List<Movie> favoriteMovies = getFavoriteMovies(userEmail);
        List<Movie> searchResults = new ArrayList<>();
        for (Movie movie : favoriteMovies) {
            if (movie.getTitle().toLowerCase().contains(keyword.toLowerCase()) ||
                    movie.getCast().toLowerCase().contains(keyword.toLowerCase()) ||
                    movie.getCategory().toLowerCase().contains(keyword.toLowerCase())) {
                searchResults.add(movie);
            }
        }
        return searchResults;
    }

}
