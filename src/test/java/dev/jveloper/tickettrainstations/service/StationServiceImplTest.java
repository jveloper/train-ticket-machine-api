package dev.jveloper.tickettrainstations.service;

import dev.jveloper.tickettrainstations.dao.StationDaoImpl;
import dev.jveloper.tickettrainstations.domain.Station;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.TestPropertySource;
import java.util.HashSet;
import java.util.Set;

@ExtendWith(MockitoExtension.class)
@TestPropertySource(locations="classpath:application.properties")
class StationServiceImplTest {

    @Mock
    StationDaoImpl stationDao;

    @InjectMocks
    StationServiceImpl stationService;


    @Test
    void getAllStationsWithNoFilter() {

       Mockito.when(stationDao.getAll(null)).thenReturn(getAllStations());
       Set<Station> stations = stationService.getAllStations(null);

       Assertions.assertThat(stations).isNotNull();
       Assertions.assertThat(stations).hasSize(20);

    }

   @Test
    void getAllStationsWithFilterAndReturnMatchedList(){

        String search = "Sant";
        Mockito.when(stationDao.getAll(search)).thenReturn(getAllStations());
        Set<Station> stations = stationService.getAllStations(search);

        Assertions.assertThat(stations).isNotNull();
        Assertions.assertThat(stations).hasSize(4);
       Assertions.assertThat(stations).extracting("isAvailable").contains(Boolean.TRUE);
        Assertions.assertThat(stations).extracting("name").isNotEmpty().contains("Santarem");

    }

    @Test
    void getAllStationsWithFilterAndReturnUniqueResult(){

        String search = "Santarem";
        Mockito.when(stationDao.getAll(search)).thenReturn(getAllStations());
        Set<Station> stations = stationService.getAllStations(search);

        Assertions.assertThat(stations).isNotNull();
        Assertions.assertThat(stations).hasSize(1);
        Assertions.assertThat(stations).extracting("name").isNotEmpty().contains("Santarem");
    }


    @Test
    void getAllNextAvailableChar_Sant(){

        String search = "Sant";
        Set<Character> nextAvailableChar = stationService.getNextAvailableChar(getAllStationsFiltered_Sant(), search);

        Assertions.assertThat(nextAvailableChar).isNotNull();
        Assertions.assertThat(nextAvailableChar).hasSize(2);
        Assertions.assertThat(nextAvailableChar).contains('a', 'o');

    }

    @Test
    void getAllNextAvailableChar_Santa(){

        String search = "Santa";
        Set<Character> nextAvailableChar = stationService.getNextAvailableChar(getAllStationsFiltered_Santa(), search);

        Assertions.assertThat(nextAvailableChar).isNotNull();
        Assertions.assertThat(nextAvailableChar).hasSize(3);
        Assertions.assertThat(nextAvailableChar).contains(' ', 'n', 'r');

    }

    //get station list

    private Set<Station> getAllStations(){

        Set<Station> stationList = new HashSet<>();

        stationList.add(Station.builder().name("Abrantes").isAvailable(true).build());
        stationList.add(Station.builder().name("Porto Campanha").isAvailable(true).build());
        stationList.add(Station.builder().name("Porto São Bento").isAvailable(true).build());
        stationList.add(Station.builder().name("Braga").isAvailable(true).build());
        stationList.add(Station.builder().name("Coimbra").isAvailable(true).build());
        stationList.add(Station.builder().name("Coimbra B").isAvailable(true).build());
        stationList.add(Station.builder().name("Aveiro").isAvailable(true).build());
        stationList.add(Station.builder().name("Vila das Aves").isAvailable(true).build());
        stationList.add(Station.builder().name("Lordelo").isAvailable(true).build());
        stationList.add(Station.builder().name("Faro").isAvailable(true).build());
        stationList.add(Station.builder().name("Santa Margarida").isAvailable(true).build());
        stationList.add(Station.builder().name("Santarem").isAvailable(true).build());
        stationList.add(Station.builder().name("Santana Cartaxo").isAvailable(true).build());
        stationList.add(Station.builder().name("Lisboa Santa Apolonia").isAvailable(true).build());
        stationList.add(Station.builder().name("Santo Amaro de Oeiras").isAvailable(true).build());
        stationList.add(Station.builder().name("Barreiro").isAvailable(true).build());
        stationList.add(Station.builder().name("Carregado").isAvailable(true).build());
        stationList.add(Station.builder().name("Lisboa Oriente").isAvailable(true).build());
        stationList.add(Station.builder().name("Azambuja").isAvailable(true).build());
        stationList.add(Station.builder().name("Obidos").isAvailable(true).build());

        return stationList;

    }

    public Set<Station> getAllStationsFiltered_Sant(){

        Set<Station> stationListFilteredSant = new HashSet<>();
        stationListFilteredSant.add(Station.builder().name("Santa Margarida").isAvailable(true).build());
        stationListFilteredSant.add(Station.builder().name("Santarem").isAvailable(true).build());
        stationListFilteredSant.add(Station.builder().name("Santana Cartaxo").isAvailable(true).build());
        stationListFilteredSant.add(Station.builder().name("Santo Amaro de Oeiras").isAvailable(true).build());

        return stationListFilteredSant;

    }

    public Set<Station> getAllStationsFiltered_Santa(){

        Set<Station> stationListFilteredSanta = new HashSet<>();
        stationListFilteredSanta.add(Station.builder().name("Santa Margarida").isAvailable(true).build());
        stationListFilteredSanta.add(Station.builder().name("Santarem").isAvailable(true).build());
        stationListFilteredSanta.add(Station.builder().name("Santana Cartaxo").isAvailable(true).build());

        return stationListFilteredSanta;

    }

}