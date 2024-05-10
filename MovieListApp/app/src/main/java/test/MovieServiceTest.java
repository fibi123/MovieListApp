package test;

import model.Movie;
import model.User;
import org.junit.Test;
import service.MovieService;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MovieServiceTest {

    @Test
    public void testAddMovie() {
        // Arrange
        MovieService movieService = new MovieService();
        Movie movie = new Movie("Inception", "Leonardo DiCaprio, Joseph Gordon-Levitt", "Sci-Fi, Action", "2010-07-16", 160000000.0);

        // Act
        movieService.addMovie(movie);
        List<Movie> movies = movieService.getAllMovies();

        // Assert
        assertEquals(1, movies.size());
        assertEquals(movie, movies.get(0));
    }

    @Test
    public void testSearchMovies() {
        // Arrange
        MovieService movieService = new MovieService();
        Movie movie1 = new Movie("Inception", "Leonardo DiCaprio, Joseph Gordon-Levitt", "Sci-Fi, Action", "2010-07-16", 160000000.0);
        Movie movie2 = new Movie("The Dark Knight", "Christian Bale, Heath Ledger", "Action, Crime, Drama", "2008-07-18", 185000000.0);
        movieService.addMovie(movie1);
        movieService.addMovie(movie2);

        // Act
        List<Movie> searchResults = movieService.searchMovies("inception");

        // Assert
        assertEquals(1, searchResults.size());
        assertEquals(movie1, searchResults.get(0));
    }

    @Test
    public void testGetAllMovies() {
        // Arrange
        MovieService movieService = new MovieService();
        Movie movie1 = new Movie("Inception", "Leonardo DiCaprio, Joseph Gordon-Levitt", "Sci-Fi, Action", "2010-07-16", 160000000.0);
        Movie movie2 = new Movie("The Dark Knight", "Christian Bale, Heath Ledger", "Action, Crime, Drama", "2008-07-18", 185000000.0);
        movieService.addMovie(movie1);
        movieService.addMovie(movie2);

        // Act
        List<Movie> movies = movieService.getAllMovies();

        // Assert
        assertEquals(2, movies.size());
        assertEquals(movie1, movies.get(0));
        assertEquals(movie2, movies.get(1));
    }

    @Test
    public void testAddFavoriteMovie() {
        // Arrange
        MovieService movieService = new MovieService();
        Movie movie = new Movie("Inception", "Leonardo DiCaprio, Joseph Gordon-Levitt", "Sci-Fi, Action", "2010-07-16", 160000000.0);
        String userEmail = "test@example.com";
        movieService.registerUser("test@example.com", "John Doe", 30);


        // Act
        movieService.addFavoriteMovie(userEmail, movie);
        List<Movie> favoriteMovies = movieService.getFavoriteMovies(userEmail);

        // Assert
        assertEquals(1, favoriteMovies.size());
        assertTrue(favoriteMovies.contains(movie));
    }


    @Test
    public void testSearchFavoriteMovies() {
        // Arrange
        MovieService movieService = new MovieService();
        Movie movie1 = new Movie("Inception", "Leonardo DiCaprio, Joseph Gordon-Levitt", "Sci-Fi, Action", "2010-07-16", 160000000.0);
        String userEmail = "test@example.com";
        movieService.registerUser(userEmail, "John Doe", 30);
        movieService.addFavoriteMovie(userEmail, movie1);

        // Act
        List<Movie> searchResults = movieService.searchFavoriteMovies(userEmail, "inception");

        // Assert
        assertEquals(1, searchResults.size());
        assertTrue(searchResults.contains(movie1));
    }

    @Test
    public void testRegisterUser() {
        // Arrange
        MovieService movieService = new MovieService();
        String userEmail = "test@example.com";
        String userName = "John Doe";
        int userAge = 30;

        // Act
        movieService.registerUser(userEmail, userName, userAge);

        // Assert
        List<User> users = movieService.getUsers();
        assertEquals(1, users.size());
        User user = users.get(0);
        assertEquals(userEmail, user.getEmail());
        assertEquals(userName, user.getName());
        assertEquals(userAge, user.getAge());
    }


}

