package za.ac.cput.controller;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.MaintenanceRecord;
import za.ac.cput.domain.Payment;
import za.ac.cput.factory.MaintenanceRecordFactory;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class MaintenanceRecordControllerTest {

    @Autowired
    private MaintenanceRecordController controller;

    private static final MaintenanceRecord maintenance =
            MaintenanceRecordFactory.createMaintenanceRecord(
                    "M001",
                    "Oil Change",
                    "2026-07-18",
                    1200.00
            );

    @Test
    @Order(1)
    void create() {

        MaintenanceRecord created = controller.create(maintenance);

        assertNotNull(created);

        System.out.println(created);
    }

    @Test
    @Order(2)
    void read() {

        MaintenanceRecord read =
                controller.read(maintenance.getMaintenanceId());

        assertNotNull(read);

        System.out.println(read);
    }

    @Test
    @Order(3)
    void update() {

        Payment updated =
                new MaintenanceRecord.Builder()
                        .copy(maintenance)
                        .setType("Major Service")
                        .build();

        MaintenanceRecord result = controller.update(updated);

        assertNotNull(result);

        System.out.println(result);
    }

    @Test
    @Order(4)
    void getAll() {

        System.out.println(controller.getAll());
    }

    @Test
    @Order(5)
    void delete() {

        controller.delete(maintenance.getMaintenanceId());

        MaintenanceRecord deleted =
                controller.read(maintenance.getMaintenanceId());

        assertNull(deleted);
    }
}