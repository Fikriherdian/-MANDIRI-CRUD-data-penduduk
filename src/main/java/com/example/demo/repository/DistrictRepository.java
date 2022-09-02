package com.example.demo.repository;

import com.example.demo.utils.Query;
import org.springframework.stereotype.Repository;
import com.example.demo.model.Regency;
import com.example.demo.model.District;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class DistrictRepository {
    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public District create(District data){

        MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue("id",data.getId());
        map.addValue("name",data.getName());
        map.addValue("regency_id", data.getRegency_id());
        map.addValue("created_at",data.getCreated_at());
        jdbcTemplate.update(Query.CREATE_DISTRICT,map);
        return data;
    }

    public List<District> list(){
        MapSqlParameterSource map = new MapSqlParameterSource();
        return jdbcTemplate.query(Query.LIST_DISTRICT, map, new RowMapper<District>() {
            @Override
            public District mapRow(ResultSet resultSet, int i) throws SQLException {

                District district = new District();
                district.setId(resultSet.getString("id"));
                district.setName(resultSet.getString("name"));
                district.setCreated_at(resultSet.getDate("created_at"));
                district.setUpdate_at(resultSet.getDate("update_at"));
                district.setRegency_id(resultSet.getString("regency_id"));

                Regency regency = new Regency();
                regency.setId(resultSet.getString("id_regency"));
                regency.setName(resultSet.getString("regency_name"));
                regency.setCreated_at(resultSet.getDate("regency_created_at"));
                regency.setUpdate_at(resultSet.getDate("regency_update_at"));
                district.setRegency_name(regency);

                return district;
            }
        });
    }

    public District getByid( String id){
        MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue("id", id);
        return jdbcTemplate.queryForObject(Query.DISTRICT_GET_BY_ID, map, new RowMapper<District>() {
            @Override
            public District mapRow(ResultSet resultSet, int i) throws SQLException {

                District district = new District();
                district.setId(resultSet.getString("id"));
                district.setName(resultSet.getString("name"));
                district.setCreated_at(resultSet.getDate("created_at"));
                district.setRegency_id(resultSet.getString("regency_id"));

                Regency regency = new Regency();
                regency.setId(resultSet.getString("id_regency"));
                regency.setName(resultSet.getString("regency_name"));
                regency.setCreated_at(resultSet.getDate("regency_created_at"));
                regency.setUpdate_at(resultSet.getDate("regency_update_at"));
                district.setRegency_name(regency);

                return  district;
            }
        });
    }

    public District update(District data){

        MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue("id",data.getId());
        map.addValue("name",data.getName());
        map.addValue("regency_id", data.getRegency_id());
        map.addValue("update_at",data.getUpdate_at());
        jdbcTemplate.update(Query.UPDATE_DISTRICT,map);

        return data;
    }

    public void delete(String id){


        MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue("id", id);
        jdbcTemplate.update(Query.DELETE_DISTRICT, map);
    }
}
