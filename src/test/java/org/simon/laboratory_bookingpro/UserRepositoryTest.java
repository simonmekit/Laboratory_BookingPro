package org.simon.laboratory_bookingpro;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.simon.laboratory_bookingpro.dto.UserDto;
import org.simon.laboratory_bookingpro.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)

public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testFindByUsername() {
        // Save a user to the repository
        UserDto user = new UserDto();
        user.setFirstName("testuser");
        user.setEmail("testuser@example.com");
        userRepository.save(user);

        // Retrieve the user by username
        UserDto found = userRepository.findByEmail("testuser@example.com");

        // Assert that the user was found
        assertThat(found).isNotNull();
        assertThat(found.getFirstName()).isEqualTo("testuser");
        assertThat(found.getEmail()).isEqualTo("testuser@example.com");
    }
}
