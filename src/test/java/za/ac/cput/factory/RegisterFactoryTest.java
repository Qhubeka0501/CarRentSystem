package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Register;

import static org.junit.jupiter.api.Assertions.*;

class RegisterFactoryTest {

    @Test
    void createRegister() {

        Register register = RegisterFactory.createRegister(
                "Alexa Benigne",
                "alexab@example.com",
                "Password123",
                "CUSTOMER"
        );

        assertNotNull(register);
        assertEquals("Alexa Benigne", register.getName());
        assertEquals("alexab@example.com", register.getEmail());
        assertEquals("Password123", register.getPassword());
        assertEquals("CUSTOMER", register.getRole());
        assertTrue(register.isActive());
    }

    @Test
    void createRegisterWithNullName() {

        assertThrows(
                IllegalArgumentException.class,
                () -> RegisterFactory.createRegister(
                        null,
                        "alexab@example.com",
                        "Password123",
                        "CUSTOMER"
                )
        );
    }

    @Test
    void createRegisterWithNullEmail() {

        assertThrows(
                IllegalArgumentException.class,
                () -> RegisterFactory.createRegister(
                        "Alexa Benigne",
                        null,
                        "Password123",
                        "CUSTOMER"
                )
        );
    }

    @Test
    void createRegisterWithNullPassword() {

        assertThrows(
                IllegalArgumentException.class,
                () -> RegisterFactory.createRegister(
                        "Alexa Benigne",
                        "alexab@example.com",
                        null,
                        "CUSTOMER"
                )
        );
    }
}