package za.ac.cput.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import za.ac.cput.service.LoginService;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(LoginController.class)
class LoginControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private LoginService loginService;

    @Test
    void authenticateSuccess() throws Exception {

        when(loginService.login(
                "test@gmail.com",
                "password123"
        )).thenReturn(true);

        mockMvc.perform(
                post("/login/authenticate")
                        .param("email", "test@gmail.com")
                        .param("password", "password123")
        ).andExpect(status().isOk());
    }

    @Test
    void authenticateFailure() throws Exception {

        when(loginService.login(
                "test@gmail.com",
                "wrongPassword"
        )).thenReturn(false);

        mockMvc.perform(
                post("/login/authenticate")
                        .param("email", "test@gmail.com")
                        .param("password", "wrongPassword")
        ).andExpect(status().isOk());
    }
}