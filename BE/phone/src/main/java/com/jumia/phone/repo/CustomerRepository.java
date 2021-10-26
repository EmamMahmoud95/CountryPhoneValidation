package com.jumia.phone.repo;

import com.jumia.phone.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * @author Emam Mahmoud
 * @Date 23th Sep 2021
 **/
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    @Transactional
    @Query(value = "select id ,name, '' AS state," +
            "        CASE " +
            "        WHEN phone  like \"(237)%\" THEN  'Cameroon'" +
            "        WHEN phone  like \"(251)%\" THEN  'Ethiopia'" +
            "        WHEN phone  like \"(212)%\" THEN  'Morocco'" +
            "        WHEN phone  like \"(258)%\" THEN  'Mozambique'" +
            "        WHEN phone  like \"(256)%\" THEN  'Uganda'" +
            "        ELSE  'invalid'    " +
            "        END country ," +
            "         " +
//            "  CASE \n" +
//            "        WHEN   regexp ( phone ,'\\(237\\)\\ ?[2368]\\d{7,8}$') THEN  'valid'\n" +
//            "        WHEN   regexp ( phone ,'\\(251\\)\\ ?[1-59]\\d{8}$')  THEN  'valid'\n" +
//            "        WHEN   regexp ( phone ,'\\(212\\)\\ ?[5-9]\\d{8}$')  THEN  'valid'\n" +
//            "        WHEN   regexp ( phone ,'\\(258\\)\\ ?[28]\\d{7,8}$')  THEN  'valid'\n" +
//            "        WHEN   regexp ( phone ,'\\(256\\)\\ ?\\d{9}$')  THEN  'valid'\n" +
//            "        ELSE  'invalid'   \n" +
//            "        END state,\n" +

            "        substr(phone, 1, instr(phone, ' ') - 1) AS country_code, " +
            "        substr(phone, instr(phone, ' ') + 1) AS number " +
            "from customer "
            + "where ((?1) IS NULL OR phone like (?1)) " +
            "group by  country," +
            "state," +
            "country_code, number ,id,name "
            , nativeQuery = true)
    Page<Customer> findAllCustomers(String countyFilter, String stateFilter, Pageable pageable);
}
