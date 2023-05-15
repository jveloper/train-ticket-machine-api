package dev.jveloper.tickettrainstations.service;

import dev.jveloper.tickettrainstations.dao.StationDaoImpl;
import dev.jveloper.tickettrainstations.domain.Station;
import dev.jveloper.tickettrainstations.helper.StringHelper;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class StationServiceImpl implements StationService {

    private final StationDaoImpl stationDao;


    public StationServiceImpl(StationDaoImpl stationDao) {
        this.stationDao = stationDao;
    }

    public Set<Station> getAllStations(String search) {

        if (search != null){
            Set<Station> stations = stationDao.getAll(search);
            return stations.stream().filter(s -> s.getName().startsWith(search)).collect(Collectors.toUnmodifiableSet());
        }
        else{
            return stationDao.getAll(null);
        }

    }

    public Set<Character> getNextAvailableChar(Set<Station> stations, String s){

        final String search = Objects.requireNonNullElse(s, "");
        Set<Character> charList = new HashSet<>();

        stations.parallelStream().forEach(station -> {
                String sub = station.getName().substring(search.length());
                if (!sub.isEmpty()) {
                    charList.add(sub.charAt(0));
                }
        });
        return charList;
    }


}
