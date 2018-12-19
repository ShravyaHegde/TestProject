package com.jwtauthentication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jwtauthentication.model.Menu;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Long>{
 
}
