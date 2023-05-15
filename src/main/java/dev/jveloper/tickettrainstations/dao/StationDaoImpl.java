package dev.jveloper.tickettrainstations.dao;

import dev.jveloper.tickettrainstations.domain.Station;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Component
public class StationDaoImpl implements DomainDao<Station> {

    private final Set<Station> stations;

    public StationDaoImpl() {

        stations = new HashSet<>();
        stations.add(Station.builder().name("Abrantes").isAvailable(true).build());
        stations.add(Station.builder().name("Porto Campanha").isAvailable(true).build());
        stations.add(Station.builder().name("Porto São Bento").isAvailable(true).build());
        stations.add(Station.builder().name("Braga").isAvailable(true).build());
        stations.add(Station.builder().name("Coimbra").isAvailable(true).build());
        stations.add(Station.builder().name("Coimbra B").isAvailable(true).build());
        stations.add(Station.builder().name("Aveiro").isAvailable(true).build());
        stations.add(Station.builder().name("Vila das Aves").isAvailable(true).build());
        stations.add(Station.builder().name("Lordelo").isAvailable(true).build());
        stations.add(Station.builder().name("Faro").isAvailable(true).build());
        stations.add(Station.builder().name("Santa Margarida").isAvailable(true).build());
        stations.add(Station.builder().name("Santarem").isAvailable(true).build());
        stations.add(Station.builder().name("Santana Cartaxo").isAvailable(true).build());
        stations.add(Station.builder().name("Lisboa Santa Apolonia").isAvailable(true).build());
        stations.add(Station.builder().name("Santo Amaro de Oeiras").isAvailable(true).build());
        stations.add(Station.builder().name("Barreiro").isAvailable(true).build());
        stations.add(Station.builder().name("Carregado").isAvailable(true).build());
        stations.add(Station.builder().name("Lisboa Oriente").isAvailable(true).build());
        stations.add(Station.builder().name("Azambuja").isAvailable(true).build());
        stations.add(Station.builder().name("Obidos").isAvailable(true).build());

    }

    @Override
    public Set<Station> getAll(String search) {
        return stations.stream()
                .collect(Collectors.toUnmodifiableSet());
    }

}
