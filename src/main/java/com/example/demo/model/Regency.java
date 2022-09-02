package com.example.demo.model;

import java.util.Date;

public class Regency {
    private String id;
    private String name;
    private String province_id;

    private Province province;
    private Date created_at;
    private Date update_at;

    public Regency(String id, String name, String province_id,Province province, Date created_at, Date update_at) {
        this.id = id;
        this.name = name;
        this.province_id = province_id;
        this.province = province;
        this.created_at = created_at;
        this.update_at = update_at;
    }

    public Regency() {
    }

    public Province getProvince() {
        return province;
    }

    public void setProvince_name(Province province) {
        this.province = province;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProvince_id() {
        return province_id;
    }

    public void setProvince_id(String province_id) {
        this.province_id = province_id;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdate_at() {
        return update_at;
    }

    public void setUpdate_at(Date update_at) {
        this.update_at = update_at;
    }
}
