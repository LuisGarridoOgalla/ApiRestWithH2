package com.javaTest.javaTest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javaTest.javaTest.model.Brand;

@Repository
public interface BrandsRepository extends JpaRepository<Brand, Integer> {

}
