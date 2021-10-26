package com.jumia.phone.controller;

import com.jumia.phone.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Emam Mahmoud
 * @Date 23th Oct 2021
 **/
@RestController
@CrossOrigin("*")
@RequestMapping(path = "/api")
public class CustomerController {

    CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }


    @GetMapping(value = "/customer")
    public ResponseEntity<?> listAllCustomer(@RequestParam(value = "county-filter",required = false) String countyFilter,
                                             @RequestParam(value = "state-filter",required = false) String stateFilter,
                                             @RequestParam(value = "page", defaultValue = "0") Integer page,
                                             @RequestParam(value = "size", defaultValue = "200") Integer size) {
        return ResponseEntity.status(HttpStatus.OK).body(customerService.listCustomers(countyFilter,stateFilter,page,size));
    }


}
