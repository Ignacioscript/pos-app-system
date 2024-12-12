package org.ignacioScript.co.service;

import org.ignacioScript.co.dao.LocationDAO;
import org.ignacioScript.co.dto.LocationDTO;
import org.ignacioScript.co.model.Location;

import java.util.List;
import java.util.stream.Collectors;

public class LocationService {

    private final LocationDAO locationDAO;

    public LocationService(){
        this.locationDAO = new LocationDAO();
    }

    public void saveLocation(LocationDTO locationDTO){
        Location location = createLocationFromDTO(locationDTO);
        locationDAO.save(location);
    }

    public void updateLocation(LocationDTO locationDTO, int id) {
        Location location =createLocationFromDTO(locationDTO);
        locationDAO.update(location, id);

    }

    public void deleteLocation(int id){
        locationDAO.delete(id);
    }

    public LocationDTO getLocationById(int id){
        Location location = locationDAO.findById(id);
        return new LocationDTO(
                location.getProvince(),
                location.getCity(),
                location.getStreet());

    }

    public List<LocationDTO> getAllLocations(){
        return locationDAO.findAll().stream()
                .map(location -> new LocationDTO(
                        location.getProvince(),
                        location.getCity(),
                        location.getStreet()))
                .collect(Collectors.toList());
    }



    //HELPER
    protected Location createLocationFromDTO(LocationDTO locationDTO){
        return new Location(
                locationDTO.getProvince(),
                locationDTO.getCity(),
                locationDTO.getStreet()
                );
    }


}
