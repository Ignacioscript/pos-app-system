package org.ignacioScript.co;

import org.ignacioScript.co.dto.CustomerDTO;


public class Main {
    public static void main(String[] args) {


        CustomerController customerController = new CustomerController();
        CustomerDTO customerDTO = customerController.findCustomerById(1);
        System.out.println(customerDTO.getFirstName());

    }
}