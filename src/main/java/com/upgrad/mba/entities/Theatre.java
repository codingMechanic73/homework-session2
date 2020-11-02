package com.upgrad.mba.entities;

import javax.persistence.*;

@Entity
public class Theatre {

    @Id
    @GeneratedValue
    private int theatreId;

    @Column(length = 20, nullable = false, unique = true)
    private String theatreName;

    @Column(nullable = false)
    private float ticketPrice = 150f;

    @ManyToOne
    @JoinColumn(name = "city_id", nullable = false)
    private City city;

    public Theatre() {
    }

    public Theatre(int theatreId, String theatreName, float ticketPrice, City city) {
        this.theatreId = theatreId;
        this.theatreName = theatreName;
        this.ticketPrice = ticketPrice;
        this.city = city;
    }

    public int getTheatreId() {
        return theatreId;
    }

    public void setTheatreId(int theatreId) {
        this.theatreId = theatreId;
    }

    public String getTheatreName() {
        return theatreName;
    }

    public void setTheatreName(String theatreName) {
        this.theatreName = theatreName;
    }

    public float getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(float ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Theatre{" +
                "theatreId=" + theatreId +
                ", theatreName='" + theatreName + '\'' +
                ", ticketPrice=" + ticketPrice +
                ", city=" + city +
                '}';
    }
}
