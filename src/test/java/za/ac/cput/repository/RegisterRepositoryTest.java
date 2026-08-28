package za.ac.cput.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import za.ac.cput.domain.Register;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class RegisterRepositoryTest {

    @Autowired
    private RegisterRepository repository;

    private Register createRegister() {
        return new Register.Builder()
                .setName("Alexa Benigne")
                .setEmail("alexab@example.com")
                .setPassword("Password123")
                .setRole("CUSTOMER")
                .setActive(true)
                .build();
    }

    @Test
    void save() {

        Register saved = repository.save(createRegister());

        assertNotNull(saved);
        assertNotNull(saved.getRegisterId());
        assertEquals("Alexa Benigne", saved.getName());
    }

    @Test
    void findById() {

        Register saved = repository.save(createRegister());

        Register found =
                repository.findById(saved.getRegisterId()).orElse(null);

        assertNotNull(found);
        assertEquals(saved.getRegisterId(), found.getRegisterId());
        assertEquals("alexab@example.com", found.getEmail());
    }

    @Test
    void findByEmail() {

        Register saved = repository.save(createRegister());

        Register found =
                repository.findByEmail(saved.getEmail());

        assertNotNull(found);
        assertEquals(saved.getEmail(), found.getEmail());
    }

    @Test
    void findAll() {

        repository.save(createRegister());

        assertFalse(repository.findAll().isEmpty());
    }

    @Test
    void deleteById() {

        Register saved = repository.save(createRegister());

        String id = saved.getRegisterId();

        repository.deleteById(id);

        assertFalse(repository.existsById(id));
    }
}