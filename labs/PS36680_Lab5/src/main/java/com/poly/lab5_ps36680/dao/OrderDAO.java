package com.poly.lab5_ps36680.dao;

import com.poly.lab5_ps36680.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;


public interface OrderDAO extends JpaRepository<Order, Long>{

}
