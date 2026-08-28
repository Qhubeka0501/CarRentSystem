package za.ac.cput.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import za.ac.cput.domain.Login;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class LoginRepositoryTest {

    @Autowired
    private LoginRepository repository;

    private Login createLogin() {

        return new Login.Builder()
                .setLoginId("LOG001")
                .setEmail("test@gmail.com")
                .setPassword("password123")
                .build();
    }

    @Test
    void save() {

        Login login = createLogin();

        Login saved = repository.save(login);

        assertNotNull(saved);
        assertEquals("LOG001", saved.getLoginId());
    }

    @Test
    void findById() {

        Login login = createLogin();

        repository.save(login);

        Optional<Login> found =
                repository.findById("LOG001");

        assertTrue(found.isPresent());
        assertEquals("test@gmail.com", found.get().getEmail());
    }

    @Test
    void findByEmail() {

        Login login = createLogin();

        repository.save(login);

        Optional<Login> found =
                repository.findByEmail("test@gmail.com");

        assertTrue(found.isPresent());
        assertEquals("LOG001", found.get().getLoginId());
    }

    @Test
    void findAll() {

        repository.save(createLogin());

        assertFalse(repository.findAll().isEmpty());
    }

    @Test
    void deleteById() {

        repository.save(createLogin());

        repository.deleteById("LOG001");

        assertFalse(repository.existsById("LOG001"));
    }
}