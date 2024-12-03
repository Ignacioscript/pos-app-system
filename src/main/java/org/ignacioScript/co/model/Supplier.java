package org.ignacioScript.co.model;

import org.ignacioScript.co.interfaces.DataTransferObject;

public class Supplier implements DataTransferObject {

    private int supplierId;
    private String supplierName;
    private Location location;

    public Supplier(int supplierId, String supplierName, Location location) {
        this.supplierId = supplierId;
        this.supplierName = supplierName;
        this.location = location;
    }

    public Supplier(String supplierName, Location location) {
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

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
