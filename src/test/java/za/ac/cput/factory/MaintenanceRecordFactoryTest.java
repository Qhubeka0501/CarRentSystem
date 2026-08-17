package za.ac.cput.factory;

/* Class Name: Review.java
 *Description: Review CarRentSystem Class
 * Author: Alphonsine Ningabiye(230426581)
 * Date: 28 June 2026
 */

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.MaintenanceRecord;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class MaintenanceRecordFactoryTest {

    @Test
    void createMaintenanceRecord() {

        MaintenanceRecord maintenanceRecord =
                MaintenanceRecordFactory.createMaintenanceRecord(
                        "V01",
                        LocalDate.now(),
                        "Oil Change",
                        2000.00,
                        "John Technician"
                );

        assertNotNull(maintenanceRecord);
        assertNotNull(maintenanceRecord.getRecordId());

        System.out.println(maintenanceRecord);
    }
}