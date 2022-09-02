package com.example.demo.model;

import java.util.Date;

public class Province {

    private String id;
    private String name;
    private Date created_at;
    private Date update_at;

    public Province(String id,String name,Date created_at,Date update_at){
        this.id = id;
        this.name = name;
        this.created_at = created_at;
        this.update_at = update_at;
    }

    public Province(){}

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
