package dev.jveloper.tickettrainstations.service;

import dev.jveloper.tickettrainstations.dao.StationDaoImpl;
import dev.jveloper.tickettrainstations.domain.Station;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public interface StationService {

    Set<Station> getAllStations(String search);

}
