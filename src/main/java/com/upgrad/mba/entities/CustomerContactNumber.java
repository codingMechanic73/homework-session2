package com.upgrad.mba.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table
public class CustomerContactNumber {

    @Column(nullable = false)
    private int mobileNumber;
}
