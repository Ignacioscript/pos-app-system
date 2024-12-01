package org.ignacioScript.co.dto;

import org.ignacioScript.co.model.Location;

public class SupplierDTO {

    private int supplierId;
    private String supplierName;
    private String location;

    public SupplierDTO(int supplierId, String supplierName, String location) {
        this.supplierId = supplierId;
        this.supplierName = supplierName;
        this.location = location;
    }

    public int getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Supplier Name= ").append(getSupplierName())
                .append(", Location= ").append(getLocation());
                return sb.toString();
    }
}
