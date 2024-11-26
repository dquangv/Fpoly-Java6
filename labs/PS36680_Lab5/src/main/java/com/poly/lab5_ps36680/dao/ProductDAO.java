package com.poly.lab5_ps36680.dao;

import com.poly.lab5_ps36680.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductDAO extends JpaRepository<Product, Integer>{

}
