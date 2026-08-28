package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.MaintenanceRecord;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

/*
 * Class Name: MaintenanceRecordFactoryTest
 * Description: Test for MaintenanceRecordFactory
 * Author: Alphonsine Ningabiye (230426581)
 */

class MaintenanceRecordFactoryTest {

    @Test
    void createMaintenanceRecord() {

        MaintenanceRecord maintenanceRecord =
                MaintenanceRecordFactory.createMaintenanceRecord(
                        "V001",
                        LocalDate.of(2026, 8, 23),
                        "Oil change",
                        850.00,
                        "John Smith"
                );

        assertNotNull(maintenanceRecord);
        assertNotNull(maintenanceRecord.getRecordId());

        assertEquals("V001", maintenanceRecord.getVehicleId());
        assertEquals(
                LocalDate.of(2026, 8, 23),
                maintenanceRecord.getDate()
        );
        assertEquals(
                "Oil change",
                maintenanceRecord.getDescription()
        );
        assertEquals(850.00, maintenanceRecord.getCost());
        assertEquals(
                "John Smith",
                maintenanceRecord.getTechnicianName()
        );
    }
}