package za.ac.cput.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import za.ac.cput.domain.Register;
import za.ac.cput.repository.RegisterRepository;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class RegisterServiceImplTest {

    @Mock
    private RegisterRepository repository;

    private RegisterServiceImpl service;

    private Register register;

    @BeforeEach
    void setUp() {

        MockitoAnnotations.openMocks(this);

        service = new RegisterServiceImpl(repository);

        register = new Register.Builder()
                .setRegisterId("REG001")
                .setName("Alexa Benigne")
                .setEmail("alexab@example.com")
                .setPassword("Password123")
                .setRole("CUSTOMER")
                .setActive(true)
                .build();
    }

    @Test
    void create() {

        when(repository.save(register)).thenReturn(register);

        Register result = service.create(register);

        assertNotNull(result);
        assertEquals("REG001", result.getRegisterId());

        verify(repository).save(register);
    }

    @Test
    void read() {

        when(repository.findById("REG001"))
                .thenReturn(Optional.of(register));

        Register result = service.read("REG001");

        assertNotNull(result);
        assertEquals("REG001", result.getRegisterId());

        verify(repository).findById("REG001");
    }

    @Test
    void update() {

        when(repository.save(register)).thenReturn(register);

        Register result = service.update(register);

        assertNotNull(result);
        assertEquals("alexab@example.com", result.getEmail());

        verify(repository).save(register);
    }

    @Test
    void delete() {

        when(repository.existsById("REG001")).thenReturn(true);

        boolean result = service.delete("REG001");

        assertTrue(result);

        verify(repository).deleteById("REG001");
    }

    @Test
    void deleteWhenNotFound() {

        when(repository.existsById("REG001")).thenReturn(false);

        boolean result = service.delete("REG001");

        assertFalse(result);

        verify(repository, never()).deleteById("REG001");
    }

    @Test
    void findAll() {

        when(repository.findAll()).thenReturn(List.of(register));

        List<Register> result = service.findAll();

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("REG001", result.get(0).getRegisterId());

        verify(repository).findAll();
    }
}