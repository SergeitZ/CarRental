package com.company.CarRental;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Vehicle {

    @Id
    private Long id;
    private String make;
    private String model;
    private Integer year;

    public Vehicle(Long id, String make, String model, Integer year) {
        this.id = id;
        this.make = make;
        this.model = model;
        this.year = year;
    }

    public Long getId() {
        return id;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public Integer getYear() {
        return year;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
