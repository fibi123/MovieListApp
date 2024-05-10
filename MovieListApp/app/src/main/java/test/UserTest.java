package test;

import model.User;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserTest {

    @Test
    public void testGetName() {
        // Arrange
        String name = "John Doe";
        User user = new User("test@example.com", "John Doe", 30);

        // Act
        user.setName(name);

        // Assert
        assertEquals(name, user.getName());
    }

    @Test
    public void testGetAge() {
        // Arrange
        int age = 25;
        User user = new User("test@example.com", "John Doe", 30);

        // Act
        user.setAge(age);

        // Assert
        assertEquals(age, user.getAge());
    }
}
