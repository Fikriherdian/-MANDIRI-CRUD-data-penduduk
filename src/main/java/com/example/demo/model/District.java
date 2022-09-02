package com.example.demo.model;




import java.util.Date;
public class District {

    private String id;
    private String name;
    private String regency_id;
    private Regency regency;
    private Date created_at;
    private Date update_at;

    public District(String id, String name, String regency_id, Regency regency, Date created_at, Date update_at) {
        this.id = id;
        this.name = name;
        this.regency_id = regency_id;
        this.regency = regency;
        this.created_at = created_at;
        this.update_at = update_at;
    }

    public District() {
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

    public String getRegency_id() {
        return regency_id;
    }

    public void setRegency_id(String regency_id) {
        this.regency_id = regency_id;
    }

    public Regency getRegency() {
        return regency;
    }

    public void setRegency_name(Regency regency) {
        this.regency = regency;
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
