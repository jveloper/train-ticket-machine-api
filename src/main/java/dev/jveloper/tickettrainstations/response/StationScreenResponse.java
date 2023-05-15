package dev.jveloper.tickettrainstations.response;

import dev.jveloper.tickettrainstations.domain.Station;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StationScreenResponse {

    private Set<Station> stations;
    private Set<Character> nextAvailableChars;

}
