package com.example.erp01.mapper;

import com.example.erp01.model.Customer;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CustomerMapper {

    int addCustomer(Customer customer);

    int deleteCustomer(Integer customerID);

    List<Customer> getAllCustomer();

    Customer getCustomerByName(String customerName);

    Customer getCustomerByID(Integer customerID);


}
