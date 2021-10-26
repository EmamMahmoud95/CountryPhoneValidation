package com.jumia.phone.service;

import com.jumia.phone.entity.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> listCustomers(String countyFilter, String stateFilter, Integer page, Integer size);
}
