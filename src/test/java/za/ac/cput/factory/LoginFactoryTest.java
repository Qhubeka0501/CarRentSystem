package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Login;

import static org.junit.jupiter.api.Assertions.*;

class LoginFactoryTest {

    @Test
    void createLogin() {

        Login login = LoginFactory.createLogin(
                "test@gmail.com",
                "password123"
        );

        assertNotNull(login);
        assertNotNull(login.getLoginId());
        assertEquals("test@gmail.com", login.getEmail());
        assertEquals("password123", login.getPassword());
    }

    @Test
    void createLoginWithInvalidEmail() {

        Login login = LoginFactory.createLogin(
                "",
                "password123"
        );

        assertNull(login);
    }

    @Test
    void createLoginWithInvalidPassword() {

        Login login = LoginFactory.createLogin(
                "test@gmail.com",
                ""
        );

        assertNull(login);
    }
}