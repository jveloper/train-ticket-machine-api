package dev.jveloper.tickettrainstations.controller;

import dev.jveloper.tickettrainstations.domain.Station;
import dev.jveloper.tickettrainstations.response.StationScreenResponse;
import dev.jveloper.tickettrainstations.service.StationServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/v1/station")
public class StationController {

    private final StationServiceImpl stationService;

    public StationController(StationServiceImpl stationService) {
        this.stationService = stationService;
    }

    @GetMapping
    public ResponseEntity<StationScreenResponse> getAllStations(@RequestParam(name = "search", required = false) String search){

        Set<Station> stationList = stationService.getAllStations(search);
        Set<Character> nextCharsAvailable = stationService.getNextAvailableChar(stationList, search);
        return new ResponseEntity<>(StationScreenResponse.builder().stations(stationList).nextAvailableChars(nextCharsAvailable).build(), HttpStatus.OK);

    }


}
