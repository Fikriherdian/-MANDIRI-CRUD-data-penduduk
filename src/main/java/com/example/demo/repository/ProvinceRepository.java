package com.example.demo.repository;

import com.example.demo.model.Province;
import com.example.demo.utils.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProvinceRepository {
    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

 public Province create(Province data){

    MapSqlParameterSource map = new MapSqlParameterSource();
    map.addValue("id",data.getId());
    map.addValue("name",data.getName());
    map.addValue("created_at",data.getCreated_at());
    jdbcTemplate.update(Query.CREATE_PROVINCE,map);
    return data;
 }

 public List<Province> list(){

    MapSqlParameterSource map = new MapSqlParameterSource();
    return jdbcTemplate.query(Query.LIST_PROVINCE, map, new BeanPropertyRowMapper<>(Province.class));
 }

    public Province getByid( String id){

        MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue("id", id);
        return jdbcTemplate.queryForObject(Query.GET_BY_ID,map, new BeanPropertyRowMapper<>(Province.class));
    }

    public Province update(Province data){

        MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue("id",data.getId());
        map.addValue("name",data.getName());
        map.addValue("update_at",data.getUpdate_at());
        jdbcTemplate.update(Query.UPDATE_PROVINCE,map);

        return data;
    }

    public void delete(String id){


        MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue("id", id);
        jdbcTemplate.update(Query.DELETE_PROVINCE, map);



    }

}
