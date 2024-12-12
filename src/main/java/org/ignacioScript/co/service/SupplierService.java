package org.ignacioScript.co.service;

import org.ignacioScript.co.dao.SupplierDAO;
import org.ignacioScript.co.dto.LocationDTO;
import org.ignacioScript.co.dto.SupplierDTO;
import org.ignacioScript.co.model.Location;
import org.ignacioScript.co.model.Supplier;

import java.util.List;
import java.util.stream.Collectors;

public class SupplierService {

    private final SupplierDAO supplierDAO;
    private final LocationService locationService;

    public SupplierService(SupplierDAO supplierDAO, LocationService locationService) {
        this.supplierDAO = supplierDAO;
        this.locationService = locationService;
    }

    public void saveSupplier(SupplierDTO supplierDTO, LocationDTO locationDTO) {
        Location location = locationService.createLocationFromDTO(locationDTO);
        Supplier supplier = createSupplierFromDTO(supplierDTO, location);
        supplierDAO.save(supplier);

    }

    public void updateSupplier(SupplierDTO supplierDTO, LocationDTO locationDTO, int id) {
        Location location = locationService.createLocationFromDTO(locationDTO);
        Supplier supplier = createSupplierFromDTO(supplierDTO, location);
        supplierDAO.update(supplier, id);
    }

    public void deleteSupplier(int id) {
        supplierDAO.delete(id);
    }

    public List<SupplierDTO> getAllSuppliers() {
            return supplierDAO.findAll().stream()
                    .map(supplier -> new SupplierDTO(
                            supplier.getSupplierName(),
                            supplier.getLocation().getCity()))
                    .collect(Collectors.toList());
    }

    public SupplierDTO getSupplierById(int id){
        Supplier supplier = supplierDAO.findById(id);
        return new SupplierDTO(
                supplier.getSupplierName(),
                supplier.getLocation().getCity()
        );
    }

    //helper methods
//    protected Location createLocationFromDTO(LocationDTO locationDTO){
//        return  new Location(
//                locationDTO.getProvince(),
//                locationDTO.getCity(),
//                locationDTO.getStreet()
//        );
//    }

    private Supplier createSupplierFromDTO(SupplierDTO supplierDTO, Location location){
        return  new Supplier(
                supplierDTO.getSupplierName(),
                location

        );
    }
}
