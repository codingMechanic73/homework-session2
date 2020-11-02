package com.upgrad.mba.dao;

import com.upgrad.mba.entities.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingDao extends JpaRepository<Booking, Integer> {
}
