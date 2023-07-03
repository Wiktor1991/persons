package com.example.juni.customers;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ICustomerRepository extends JpaRepository<Customer, Integer> {
    @Modifying
    @Query(value = "update Customer set firstName=:name, lastName=:lastName,email=:email,phone=:phoneNumber where id=:id")
    @Transactional
    void modify(@Param("id") Integer id,
                @Param("name") String firstName,
                @Param("lastName") String lastName,
                @Param("email") String email,
                @Param("phoneNumber") String phone
    );

    @Modifying
    @Query( value="update Customer set firstName=:name where id=:id")
    @Transactional
    void update(@Param ("id")Integer id,
                @Param("name")String name);

}
