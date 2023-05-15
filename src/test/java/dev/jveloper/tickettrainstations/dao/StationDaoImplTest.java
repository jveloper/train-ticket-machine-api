package dev.jveloper.tickettrainstations.dao;

import dev.jveloper.tickettrainstations.domain.Station;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.TestPropertySource;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@TestPropertySource(locations="classpath:application.properties")
class StationDaoImplTest {

    @InjectMocks
    private StationDaoImpl dao;

    @Test
    void getAllStations(){

        Set<Station> stations = dao.getAll(null);
        Assertions.assertEquals(20, stations.size());

    }

}