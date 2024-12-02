package org.ignacioScript.co.service;

import org.ignacioScript.co.dao.SupplierDAO;
import org.ignacioScript.co.dto.SupplierDTO;
import org.ignacioScript.co.model.Supplier;

import java.util.List;
import java.util.stream.Collectors;

public class SupplierService {

    private final SupplierDAO supplierDAO;

    public SupplierService(SupplierDAO supplierDAO) {
        this.supplierDAO = new SupplierDAO();
    }

    public void saveSupplier(Supplier supplier) {
        supplierDAO.save(supplier);
    }

    public void updateSupplier(Supplier supplier, int id) {
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
}
