package org.ignacioScript.co;

import org.ignacioScript.co.controller.CustomerController;
import org.ignacioScript.co.dao.CustomerDAO;
import org.ignacioScript.co.dto.CustomerDTO;
import org.ignacioScript.co.service.CustomerService;


public class Main {
    public static void main(String[] args) {


        CustomerController customerController = new CustomerController(new CustomerService(new CustomerDAO()));
       System.out.println(customerController.findCustomerById(1).getFirstName());

        //customerController.saveCustomer("Alan", "Harper", "harper_alan@mail.com", "444-222-3312");

    }
}