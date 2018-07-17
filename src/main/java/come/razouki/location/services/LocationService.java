package come.razouki.location.services;


import come.razouki.location.entities.Location;

import java.util.List;
import java.util.Optional;

public interface LocationService {

    // Mark: -Service layer

    Location saveLocation(Location location);
    Location updateLocation(Location location);

    void deleteLocation(Location location);
    Optional<Location> getLocationById(int id);
    List<Location>getAllLocations();

}
