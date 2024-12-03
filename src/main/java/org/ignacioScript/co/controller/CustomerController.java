package org.ignacioScript.co.controller;

import org.ignacioScript.co.dto.CustomerDTO;
import org.ignacioScript.co.service.CustomerService;

import java.util.List;

public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }



    public void saveCustomer(String firstName, String lastName, String email, String phoneNumber){
        CustomerDTO customerDTO = new CustomerDTO(
                firstName,
                lastName,
                email,
                phoneNumber);

        customerService.createCustomer(customerDTO);
    }

    public void updateCustomer(int id, String firstName, String lastName, String email, String phoneNumber){
        CustomerDTO customerDTO = new CustomerDTO(
                firstName,
                lastName,
                email,
                phoneNumber);

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
