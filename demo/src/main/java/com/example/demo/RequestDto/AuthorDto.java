package com.example.demo.RequestDto;

import javax.persistence.Column;

public class AuthorDto {

    private String name;

    private String address;

    @Column(name = "Mobile_Number")
    private String mobNo;

    private double rating;


    public AuthorDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobNo() {
        return mobNo;
    }

    public void setMobNo(String mobNo) {
        this.mobNo = mobNo;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

}
