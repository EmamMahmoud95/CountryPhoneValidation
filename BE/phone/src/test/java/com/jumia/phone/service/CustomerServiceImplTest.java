package com.jumia.phone.service;

import com.jumia.phone.entity.Customer;
import com.jumia.phone.enums.CountryCodeEnum;
import com.jumia.phone.repo.CustomerRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import java.util.regex.Pattern;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CustomerServiceImplTest {

    @InjectMocks
    CustomerServiceImpl customerService;

    @Mock
    CustomerRepository customerRepository;



    @Test
    public void getAllEmployeesTest_withoutFilter(){
        when(customerRepository.findAllCustomers(any(),any(),any()))
                .thenReturn(getCustomerPage());

        var customers=customerService.listCustomers(null,null,0,2);
        assertEquals(3, customers.size());


    }
    @Test
    public void getAllEmployeesTest_InvalidStateFilter(){
        when(customerRepository.findAllCustomers(any(),any(),any()))
                .thenReturn(getCustomerPage());

        var customers=customerService.listCustomers(null,"invalid",0,2);
        assertEquals(1, customers.size());


    }
    @Test
    public void getAllEmployeesTest_validStateFilter(){
        when(customerRepository.findAllCustomers(any(),any(),any()))
                .thenReturn(getCustomerPage());

        var customers=customerService.listCustomers(null,"valid",0,2);
        assertEquals(2, customers.size());


    }

    private Page getCustomerPage() {
        List<Customer> list = Arrays.asList(
                new Customer(1,"test name","(212)","698054317","Morocco","valid"),
                new Customer(1,"test name3","(212)","691933626","Morocco","valid"),

                new Customer(1,"test name2","(212)","6007989253","Morocco","invalid")
        );
       return new PageImpl<>(list);
    }


}
