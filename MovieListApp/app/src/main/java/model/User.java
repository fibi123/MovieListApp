package model;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String email;
    private String name;
    private int age;
    private List<Movie> favoriteMovies;

    public User(String email, String name, int age) {
        this.email = email;
        this.name = name;
        this.age = age;
        this.favoriteMovies = new ArrayList<>();
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Movie> getFavoriteMovies() {
        return favoriteMovies;
    }

    public void addFavoriteMovie(Movie movie) {
        favoriteMovies.add(movie);
    }

    public void removeFavoriteMovie(Movie movie) {
        favoriteMovies.remove(movie);
    }
}
