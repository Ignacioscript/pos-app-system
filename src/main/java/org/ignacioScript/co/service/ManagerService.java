package org.ignacioScript.co.service;

import org.ignacioScript.co.dao.ManagerDAO;
import org.ignacioScript.co.dto.ManagerDTO;
import org.ignacioScript.co.model.Manager;

import java.util.List;
import java.util.stream.Collectors;

public class ManagerService {

    private final ManagerDAO managerDAO;

    public ManagerService(ManagerDAO managerDAO) {
        this.managerDAO = new ManagerDAO();
    }

    public void saveManager(Manager manager) {
        managerDAO.save(manager);
    }

    public void updateManager(Manager manager, int id) {
        managerDAO.update(manager, id);
    }

    public void deleteManager(int id) {
        managerDAO.delete(id);
    }

    public List<ManagerDTO> getAllManagers() {
        return managerDAO.findAll().stream()
                .map(manager -> new ManagerDTO(
                        manager.getFirstName() + " " + manager.getLastName(),
                        manager.getEmail(),
                        manager.getPhoneNumber(),
                        manager.getLocation().getCity()))
                .collect(Collectors.toList());
    }

    public ManagerDTO getManagerById(int id) {
        Manager manager = managerDAO.findById(id);
        return new ManagerDTO(
                manager.getFirstName() + " " + manager.getLastName(),
                manager.getEmail(),
                manager.getPhoneNumber(),
                manager.getLocation().getCity());
    }
}
