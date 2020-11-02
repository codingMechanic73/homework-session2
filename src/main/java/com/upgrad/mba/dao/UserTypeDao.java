package com.upgrad.mba.dao;

import com.upgrad.mba.entities.UserType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserTypeDao extends JpaRepository<UserType, Integer> {

}
