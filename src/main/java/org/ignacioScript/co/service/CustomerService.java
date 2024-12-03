package org.ignacioScript.co.service;

import org.ignacioScript.co.dao.CustomerDAO;
import org.ignacioScript.co.dto.CustomerDTO;
import org.ignacioScript.co.model.Customer;

import java.util.List;
import java.util.stream.Collectors;

public class CustomerService {

    private CustomerDAO customerDAO;

    public CustomerService(CustomerDAO customerDAO){
        this.customerDAO = customerDAO;
    }



    public void createCustomer(CustomerDTO customerDTO){
        Customer customer = new Customer(
                customerDTO.getFirstName(),
                customerDTO.getLastName(),
                customerDTO.getEmail(),
                customerDTO.getPhoneNumber());
        customerDAO.save(customer);
    }

    public void updateCustomer(CustomerDTO customerDTO, int id){
        Customer customer = new Customer(
                customerDTO.getFirstName(),
                customerDTO.getLastName(),
                customerDTO.getEmail(),
                customerDTO.getPhoneNumber()
        );
        customerDAO.update(customer, id);
    }

    public void deleteCustomer(int id){
        customerDAO.delete(id);
    }

    public List<CustomerDTO> findAllCustomers(){
        return customerDAO.findAll().stream()
                .map(customer-> new CustomerDTO(
                        customer.getFirstName(),
                        customer.getLastName(),
                        customer.getEmail(),
                        customer.getPhoneNumber()))
                .collect(Collectors.toList());

    }

    public CustomerDTO findCustomerById(int id){
        Customer customer = customerDAO.findById(id);
        return new CustomerDTO(
                customer.getFirstName(),
                customer.getLastName(),
                customer.getEmail(),
                customer.getPhoneNumber());
    }

}
