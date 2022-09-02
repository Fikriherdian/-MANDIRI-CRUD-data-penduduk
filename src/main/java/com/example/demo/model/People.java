package com.example.demo.model;

import lombok.Data;

import java.util.Date;
@Data
public class People {
    private  String id;
    private  String name;

    private  String nik;
    private  String gender;
    private  Date dob;
    private String pob;

    private String province_id;

    private String regency_id;

    private String district_id;

    private Province province;
    private Regency regency;
    private District district;

    private Date created_at;
    private Date update_at;

    public People(String id, String name, String gender, Date dob, String pob, Province province, Regency regency, District district, Date created_at, Date update_at) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.dob = dob;
        this.pob = pob;
        this.province = province;
        this.regency = regency;
        this.district = district;
        this.created_at = created_at;
        this.update_at = update_at;
    }

    public People() {
    }



}
