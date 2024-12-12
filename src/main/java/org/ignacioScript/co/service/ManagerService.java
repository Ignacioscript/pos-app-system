package org.ignacioScript.co.service;

import org.ignacioScript.co.dao.ManagerDAO;
import org.ignacioScript.co.dto.LocationDTO;
import org.ignacioScript.co.dto.ManagerDTO;
import org.ignacioScript.co.model.Location;
import org.ignacioScript.co.model.Manager;

import java.util.List;
import java.util.stream.Collectors;

public class ManagerService {

    private final ManagerDAO managerDAO;
    private final LocationService locationService;

    public ManagerService(ManagerDAO managerDAO, LocationService locationService) {
        this.managerDAO = managerDAO;
        this.locationService = locationService;
    }




    public void saveManager(ManagerDTO managerDTO, LocationDTO locationDTO) {

        Location location = locationService.createLocationFromDTO(locationDTO);
        Manager manager = createManagerFromDTO(managerDTO, location);

        managerDAO.save(manager);


    }



    public void updateManager(int id, ManagerDTO managerDTO, LocationDTO locationDTO) {
        Location location = locationService.createLocationFromDTO(locationDTO);
        Manager manager = createManagerFromDTO(managerDTO, location);
        managerDAO.update(manager, id);
    }

    public void deleteManager(int id) {
        managerDAO.delete(id);
    }

    public List<ManagerDTO> getAllManagers() {


        return managerDAO.findAll().stream()
                .map(manager -> new ManagerDTO(
                        manager.getFirstName(),
                        manager.getLastName(),
                        manager.getEmail(),
                        manager.getPhoneNumber(),
                        new LocationDTO(
                                manager.getLocation().getProvince(),
                                manager.getLocation().getCity(),
                                manager.getLocation().getStreet())))
                .collect(Collectors.toList());
    }

    public ManagerDTO getManagerById(int id) {
        Manager manager = managerDAO.findById(id);
        return new ManagerDTO(
                manager.getFirstName(),
                manager.getLastName(),
                manager.getEmail(),
                manager.getPhoneNumber(),
                new LocationDTO(
                        manager.getLocation().getProvince(),
                        manager.getLocation().getCity(),
                        manager.getLocation().getStreet()));
    }

    //HELPER

    private Manager createManagerFromDTO(ManagerDTO managerDTO, Location location){
        return new Manager(
                managerDTO.getManagerName(),
                managerDTO.getManagerLastName(),
                managerDTO.getManagerEmail(),
                managerDTO.getManagerPhone(),
                location

        );
    }
}

