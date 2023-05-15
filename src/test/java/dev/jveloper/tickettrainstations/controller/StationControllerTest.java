package dev.jveloper.tickettrainstations.controller;

import dev.jveloper.tickettrainstations.domain.Station;
import dev.jveloper.tickettrainstations.service.StationServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.HashSet;
import java.util.Set;

@WebMvcTest(controllers = StationController.class)
@TestPropertySource(locations="classpath:application.properties")
class StationControllerTest {

    @MockBean
    private StationServiceImpl stationService;
    @Autowired
    private MockMvc mockMvc;


    @Test
    void getAllStationsURL() throws Exception {

        Mockito.when(stationService.getAllStations(ArgumentMatchers.any())).thenReturn(getTestStationList());
        Mockito.when(stationService.getNextAvailableChar(getTestStationList(), null)).thenReturn(getNextAvailableCharList());

        ResultActions response = mockMvc.perform(MockMvcRequestBuilders.get("/v1/station"));

        response.andExpect(MockMvcResultMatchers.status().isOk());
        response.andExpect(MockMvcResultMatchers.jsonPath("$.stations").isArray());
        response.andExpect(MockMvcResultMatchers.jsonPath("$.nextAvailableChars").isArray());
        response.andExpect(MockMvcResultMatchers.jsonPath("$.nextAvailableChars").isNotEmpty());
        response.andExpect(MockMvcResultMatchers.jsonPath("$.stations.length()").value(getTestStationList().size()));

    }

    @Test
    void getAllStationsURLWithSearchParam() throws Exception {

        String search = "Por";

        Mockito.when(stationService.getAllStations(search)).thenReturn(getTestStationListWithParam());
        Mockito.when(stationService.getNextAvailableChar(getTestStationList(), search)).thenReturn(getNextAvailableCharList());

        ResultActions response = mockMvc.perform(MockMvcRequestBuilders.get("/v1/station").queryParam("search", search));

        response.andExpect(MockMvcResultMatchers.status().isOk());
        response.andExpect(MockMvcResultMatchers.jsonPath("$.stations").isArray());
        response.andExpect(MockMvcResultMatchers.jsonPath("$.nextAvailableChars").isArray());
        response.andExpect(MockMvcResultMatchers.jsonPath("$.stations.length()").value(2));

    }

    private Set<Station> getTestStationList(){

        Set<Station> stations = new HashSet<>();
        stations.add(Station.builder().name("Abrantes").isAvailable(true).build());
        stations.add(Station.builder().name("Porto Campanhã").isAvailable(true).build());
        stations.add(Station.builder().name("Porto São Bento").isAvailable(true).build());
        stations.add(Station.builder().name("Braga").isAvailable(true).build());

        return stations;

    }

    private Set<Station> getTestStationListWithParam(){

        Set<Station> stations = new HashSet<>();
        stations.add(Station.builder().name("Porto Campanhã").isAvailable(true).build());
        stations.add(Station.builder().name("Porto São Bento").isAvailable(true).build());

        return stations;

    }

    private Set<Character> getNextAvailableCharList(){

        Set<Character> stations = new HashSet<>();
        stations.add('o');
        stations.add('a');

        return stations;

    }
}