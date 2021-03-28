package com.javaTest.javaTest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javaTest.javaTest.model.Price;

@Repository
public interface PricesRepository extends JpaRepository<Price, Integer> {

}
