package org.ignacioScript.co.dto;



public class SupplierDTO {


    private String supplierName;
    private String location;

    public SupplierDTO(String supplierName, String location) {

        this.supplierName = supplierName;
        this.location = location;
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
