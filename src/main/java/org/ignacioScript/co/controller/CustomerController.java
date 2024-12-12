package org.ignacioScript.co.controller;

import org.ignacioScript.co.dto.CustomerDTO;
import org.ignacioScript.co.service.CustomerService;

import java.util.List;

public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }



    public void saveCustomer(CustomerDTO customerDTO){
        customerService.createCustomer(customerDTO);
    }

    public void updateCustomer(int id, CustomerDTO customerDTO){
        customerService.updateCustomer(customerDTO, id);
    }

    public void deleteCustomer(int id){
        customerService.deleteCustomer(id);
    }


    public List<CustomerDTO> findAllCustomers(){
        return customerService.findAllCustomers();
    }

    public CustomerDTO findCustomerById(int id){
        return customerService.findCustomerById(id);
    }


}
