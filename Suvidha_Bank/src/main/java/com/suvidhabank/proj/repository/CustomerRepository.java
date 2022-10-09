package com.suvidhabank.proj.repository;

import org.springframework.data.repository.CrudRepository;

import com.suvidhabank.proj.entity.Customer;

public interface CustomerRepository  extends CrudRepository<Customer, String>{

}
