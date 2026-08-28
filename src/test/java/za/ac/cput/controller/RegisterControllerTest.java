package za.ac.cput.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import za.ac.cput.domain.Register;
import za.ac.cput.service.RegisterService;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(RegisterController.class)
class RegisterControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;
    @MockitoBean
    private RegisterService registerService;

    private Register createRegister() {

        return new Register.Builder()
                .setRegisterId("REG001")
                .setName("Alphonsine Ningabiye")
                .setEmail("alphonsine@example.com")
                .setPassword("Password123")
                .setRole("CUSTOMER")
                .setActive(true)
                .build();
    }

    @Test
    void create() throws Exception {

        Register register = createRegister();

        when(registerService.create(any(Register.class)))
                .thenReturn(register);

        mockMvc.perform(post("/register/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(register)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name")
                        .value("Alphonsine Ningabiye"))
                .andExpect(jsonPath("$.email")
                        .value("alphonsine@example.com"));

        verify(registerService).create(any(Register.class));
    }

    @Test
    void read() throws Exception {

        Register register = createRegister();

        when(registerService.read("REG001"))
                .thenReturn(register);

        mockMvc.perform(get("/register/read/REG001"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.registerId")
                        .value("REG001"));

        verify(registerService).read("REG001");
    }

    @Test
    void update() throws Exception {

        Register register = createRegister();

        when(registerService.update(any(Register.class)))
                .thenReturn(register);

        mockMvc.perform(put("/register/update")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(register)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.email")
                        .value("alphonsine@example.com"));

        verify(registerService).update(any(Register.class));
    }

    @Test
    void delete() throws Exception {

        when(registerService.delete("REG001"))
                .thenReturn(true);

        mockMvc.perform(MockMvcRequestBuilders.delete("/register/delete/REG001"))
                .andExpect(status().isOk())
                .andExpect(content().string("true"));

        verify(registerService).delete("REG001");
    }

    @Test
    void getAll() throws Exception {

        Register register = createRegister();

        when(registerService.findAll())
                .thenReturn(List.of(register));

        mockMvc.perform(get("/register/getAll"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("R.length()")
                        .value(1))
                .andExpect(jsonPath("R[0].name")
                        .value("Alexi Benigne"));

        verify(registerService).findAll();
    }
}