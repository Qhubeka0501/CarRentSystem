package za.ac.cput.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import za.ac.cput.domain.MaintenanceRecord;
import za.ac.cput.factory.MaintenanceRecordFactory;
import za.ac.cput.repository.MaintenanceRecordRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class MaintenanceRecordServiceImplTest {

    @Mock
    private MaintenanceRecordRepository repository;

    private MaintenanceRecordService service;
    private MaintenanceRecord maintenanceRecord;

    @BeforeEach
    void setUp() {

        service = new MaintenanceRecordServiceImpl(repository);

        maintenanceRecord =
                MaintenanceRecordFactory.createMaintenanceRecord(
                        "V001",
                        LocalDate.now(),
                        "Oil Change",
                        20000.00,
                        "John Technician"
                );
    }

    @Test
    void create() {

        when(repository.save(maintenanceRecord))
                .thenReturn(maintenanceRecord);

        MaintenanceRecord created =
                service.create(maintenanceRecord);

        assertNotNull(created);
        assertEquals(
                maintenanceRecord.getRecordId(),
                created.getRecordId()
        );

        verify(repository).save(maintenanceRecord);
    }

    @Test
    void read() {

        when(repository.findById(maintenanceRecord.getRecordId()))
                .thenReturn(Optional.of(maintenanceRecord));

        MaintenanceRecord found =
                service.read(maintenanceRecord.getRecordId());

        assertNotNull(found);
        assertEquals(
                maintenanceRecord.getRecordId(),
                found.getRecordId()
        );

        verify(repository)
                .findById(maintenanceRecord.getRecordId());
    }

    @Test
    void update() {

        MaintenanceRecord updated =
                new MaintenanceRecord.Builder()
                        .copy(maintenanceRecord)
                        .setDescription("Full Vehicle Service")
                        .build();

        when(repository.save(updated))
                .thenReturn(updated);

        MaintenanceRecord result =
                service.update(updated);

        assertNotNull(result);
        assertEquals(
                "Full Vehicle Service",
                result.getDescription()
        );

        verify(repository).save(updated);
    }

    @Test
    void delete() {

        when(repository.existsById(
                maintenanceRecord.getRecordId()))
                .thenReturn(true);

        doNothing().when(repository)
                .deleteById(maintenanceRecord.getRecordId());

        boolean deleted =
                service.delete(maintenanceRecord.getRecordId());

        assertTrue(deleted);

        verify(repository)
                .existsById(maintenanceRecord.getRecordId());

        verify(repository)
                .deleteById(maintenanceRecord.getRecordId());
    }

    @Test
    void findAll() {

        when(repository.findAll())
                .thenReturn(List.of(maintenanceRecord));

        List<MaintenanceRecord> result =
                service.findAll();

        assertNotNull(result);
        assertEquals(1, result.size());

        verify(repository).findAll();
    }
}