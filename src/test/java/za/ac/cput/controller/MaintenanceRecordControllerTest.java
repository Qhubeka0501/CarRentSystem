package za.ac.cput.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import za.ac.cput.domain.MaintenanceRecord;
import za.ac.cput.service.MaintenanceRecordService;

import java.time.LocalDate;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/*
 * Class Name: MaintenanceRecordControllerTest
 * Description: Controller test for MaintenanceRecord
 * Author: Alphonsine Ningabiye (230426581)
 * Date: 23 August 2026
 */

@WebMvcTest(MaintenanceRecordController.class)
class MaintenanceRecordControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockitoBean
    private MaintenanceRecordService maintenanceRecordService;

    private MaintenanceRecord createRecord() {

        return new MaintenanceRecord.Builder()
                .setRecordId("MR001")
                .setVehicleId("V001")
                .setDate(LocalDate.of(2026, 8, 23))
                .setDescription("Oil change")
                .setCost(850.00)
                .setTechnicianName("John")
                .build();
    }

    @Test
    void create() throws Exception {

        MaintenanceRecord record = createRecord();

        when(maintenanceRecordService.create(any(MaintenanceRecord.class)))
                .thenReturn(record);

        mockMvc.perform(post("/maintenanceRecord/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(record)))
                .andExpect(status().isOk());

        verify(maintenanceRecordService)
                .create(any(MaintenanceRecord.class));
    }

    @Test
    void read() throws Exception {

        MaintenanceRecord record = createRecord();

        when(maintenanceRecordService.read("MR001"))
                .thenReturn(record);

        mockMvc.perform(get("/maintenanceRecord/read/MR001"))
                .andExpect(status().isOk());

        verify(maintenanceRecordService)
                .read("MR001");
    }

    @Test
    void update() throws Exception {

        MaintenanceRecord record = createRecord();

        when(maintenanceRecordService.update(any(MaintenanceRecord.class)))
                .thenReturn(record);

        mockMvc.perform(put("/maintenanceRecord/update")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(record)))
                .andExpect(status().isOk());

        verify(maintenanceRecordService)
                .update(any(MaintenanceRecord.class));
    }

    @Test
    void delete() throws Exception {

        when(maintenanceRecordService.delete("MR001"))
                .thenReturn(true);

        mockMvc.perform(MockMvcRequestBuilders.delete("/maintenanceRecord/delete/MR001"))
                .andExpect(status().isOk());

        verify(maintenanceRecordService)
                .delete("MR001");
    }

    @Test
    void getAll() throws Exception {

        MaintenanceRecord record = createRecord();

        when(maintenanceRecordService.findAll())
                .thenReturn(List.of(record));

        mockMvc.perform(get("/maintenanceRecord/getAll"))
                .andExpect(status().isOk());

        verify(maintenanceRecordService)
                .findAll();
    }
}