package com.example.erp01.mapper;

import com.example.erp01.model.Customer;

import java.util.List;

public interface CustomerMapper {

    int addCustomer(Customer customer);

    int deleteCustomer(Customer customer);

    int deleteCustomerByID(Integer customerID);

    int updateCustomer(Customer customer);

    Customer getCustomerByID(Integer customerID);

    Customer getCustomerByName(String customerName);

    List<Customer> getAllCustomer();

}
