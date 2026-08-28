package za.ac.cput.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import za.ac.cput.domain.Login;
import za.ac.cput.repository.LoginRepository;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class LoginServiceImplTest {

    @Mock
    private LoginRepository repository;

    private LoginServiceImpl service;

    private Login login;

    @BeforeEach
    void setUp() {

        MockitoAnnotations.openMocks(this);

        service = new LoginServiceImpl(repository);

        login = new Login.Builder()
                .setLoginId("LOG001")
                .setEmail("test@gmail.com")
                .setPassword("password123")
                .build();
    }

    @Test
    void create() {

        when(repository.save(login)).thenReturn(login);

        Login result = service.create(login);

        assertNotNull(result);
        assertEquals("LOG001", result.getLoginId());

        verify(repository).save(login);
    }

    @Test
    void read() {

        when(repository.findById("LOG001"))
                .thenReturn(Optional.of(login));

        Login result = service.read("LOG001");

        assertNotNull(result);
        assertEquals("test@gmail.com", result.getEmail());
    }

    @Test
    void update() {

        when(repository.save(login)).thenReturn(login);

        Login result = service.update(login);

        assertNotNull(result);
        verify(repository).save(login);
    }

    @Test
    void delete() {

        when(repository.existsById("LOG001"))
                .thenReturn(true);

        boolean result = service.delete("LOG001");

        assertTrue(result);

        verify(repository).deleteById("LOG001");
    }

    @Test
    void findAll() {

        when(repository.findAll())
                .thenReturn(List.of(login));

        List<Login> result = service.findAll();

        assertEquals(1, result.size());
    }

    @Test
    void loginSuccessful() {

        when(repository.findByEmail("test@gmail.com"))
                .thenReturn(Optional.of(login));

        boolean result =
                service.login("test@gmail.com", "password123");

        assertTrue(result);
    }

    @Test
    void loginFailed() {

        when(repository.findByEmail("test@gmail.com"))
                .thenReturn(Optional.of(login));

        boolean result =
                service.login("test@gmail.com", "wrongPassword");

        assertFalse(result);
    }

    @Test
    void loginUserNotFound() {

        when(repository.findByEmail("unknown@gmail.com"))
                .thenReturn(Optional.empty());

        boolean result =
                service.login("unknown@gmail.com", "password123");

        assertFalse(result);
    }
}