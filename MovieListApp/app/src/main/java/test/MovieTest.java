package test;

import model.Movie;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MovieTest {

    @Test
    public void testMovieAttributes() {
        // Arrange
        String title = "Inception";
        String cast = "Leonardo DiCaprio, Joseph Gordon-Levitt";
        String category = "Sci-Fi, Action";
        String releaseDate = "2010-07-16";
        double budget = 160000000.0;

        // Act
        Movie movie = new Movie(title, cast, category, releaseDate, budget);

        // Assert
        assertEquals(title, movie.getTitle());
        assertEquals(cast, movie.getCast());
        assertEquals(category, movie.getCategory());
        assertEquals(releaseDate, movie.getReleaseDate());
        assertEquals(budget, movie.getBudget(), 0.01);
    }
}
