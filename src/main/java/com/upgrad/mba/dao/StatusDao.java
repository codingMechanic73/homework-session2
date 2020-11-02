package com.upgrad.mba.dao;

import com.upgrad.mba.entities.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusDao extends JpaRepository<Status, Integer> {
}
