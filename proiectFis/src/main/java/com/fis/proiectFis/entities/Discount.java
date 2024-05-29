package com.fis.proiectFis.entities;

//package com.fis.proiectFis.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Discount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int discount_id;

    private double roundTripDiscount;
    private double lastMinuteDiscount;

    public Discount(double roundTripDiscount, double lastMinuteDiscount) {
        this.roundTripDiscount = roundTripDiscount;
        this.lastMinuteDiscount = lastMinuteDiscount;
    }

    public Discount() {
    }

    public int getId() {
        return discount_id;
    }

    public void setId(int id) {
        this.discount_id = id;
    }

    public double getRoundTripDiscount() {
        return roundTripDiscount;
    }

    public void setRoundTripDiscount(double roundTripDiscount) {
        this.roundTripDiscount = roundTripDiscount;
    }

    public double getLastMinuteDiscount() {
        return lastMinuteDiscount;
    }

    public void setLastMinuteDiscount(double lastMinuteDiscount) {
        this.lastMinuteDiscount = lastMinuteDiscount;
    }

    @Override
    public String toString() {
        return "Discount{" +
                "id=" + discount_id +
                ", roundTripDiscount=" + roundTripDiscount +
                ", lastMinuteDiscount=" + lastMinuteDiscount +
                '}';
    }
}
