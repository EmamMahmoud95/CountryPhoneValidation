package com.jumia.phone.service;

import com.jumia.phone.entity.Customer;
import com.jumia.phone.enums.CountryCodeEnum;
import com.jumia.phone.repo.CustomerRepository;
import com.jumia.phone.utils.DBUtils;
import com.jumia.phone.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;


    @Override
    public List<Customer> listCustomers(String countyFilter, String stateFilter, Integer page, Integer size) {
        countyFilter = DBUtils.getCountyFilterCodeQuery(countyFilter);
        return customerRepository.findAllCustomers(countyFilter, stateFilter, PageRequest.of(page, size))
                .getContent().stream().map(customer -> {
                    customer.setState(getCustomerState(customer));
                    return customer;
                }).filter(customer -> {
                    if (StringUtils.isBlank(stateFilter))
                        return true;
                    else {
                        return customer.getState().equals(stateFilter);
                    }
                }).collect(Collectors.toList());
    }

    private String getCustomerState(Customer customer) {
        if (Pattern.compile(Optional.ofNullable(CountryCodeEnum.getName(customer.getCountry())).map(CountryCodeEnum::getRegex).orElse("")).matcher(customer.getCountry_code() + customer.getNumber()).find()) {
            return "valid";
        }
        return "invalid";
    }

}
