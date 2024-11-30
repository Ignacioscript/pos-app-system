package org.ignacioScript.co.controller;

import org.ignacioScript.co.dto.CustomerDTO;
import org.ignacioScript.co.model.Customer;
import org.ignacioScript.co.service.CustomerService;

import java.util.List;

public class CustomerController {

    private CustomerService customerService;

    public CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }

    public CustomerController(){
        this.customerService = new CustomerService();
    }

    public void createCustomer(Customer customer){
        customerService.saveCustomer(customer);
    }

    public void updateCustomer(Customer customer, int id){
        customerService.updateCustomer(customer, id);
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
