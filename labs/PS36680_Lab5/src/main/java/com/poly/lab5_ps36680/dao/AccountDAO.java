package com.poly.lab5_ps36680.dao;

import com.poly.lab5_ps36680.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AccountDAO extends JpaRepository<Account, String>{

}
