package za.ac.cput.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.MaintenanceRecord;
import za.ac.cput.factory.MaintenanceRecordFactory;
import java.time.LocalDate;

class MaintenanceRecordServiceImplTest {

    private MaintenanceRecordService service;
    private MaintenanceRecord maintenanceRecord;

    @BeforeEach
    void setUp() {

        service = MaintenanceRecordServiceImpl.getService();

        maintenanceRecord = MaintenanceRecordFactory.createMaintenanceRecord(
                "V001",
                LocalDate.now(),
                "Oil Change",
                20000.00,
                "John Technician"
        );
    }

    @Test
    void create() {

        MaintenanceRecord created = service.create(maintenanceRecord);

        assertNotNull(created);
        assertEquals(maintenanceRecord.getRecordId(), created.getRecordId());
    }

    @Test
    void read() {

        service.create(maintenanceRecord);

        MaintenanceRecord found = service.read(maintenanceRecord.getRecordId());

        assertNotNull(found);
        assertEquals(maintenanceRecord.getRecordId(), found.getRecordId());
    }

    @Test
    void update() {

        service.create(maintenanceRecord);

        MaintenanceRecord updated = new MaintenanceRecord.Builder()
                .copy(maintenanceRecord)
                .setDescription("Full Vehicle Service")
                .build();

        MaintenanceRecord result = service.update(updated);

        assertNotNull(result);
        assertEquals("Full Vehicle Service", result.getDescription());
    }

    @Test
    void delete() {

        service.create(maintenanceRecord);

        boolean deleted = service.delete(maintenanceRecord.getRecordId());

        assertTrue(deleted);
    }
}