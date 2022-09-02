package com.example.demo.repository;

import com.example.demo.model.Province;
import com.example.demo.model.Regency;
import com.example.demo.utils.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class RegencyRepository {
    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public Regency create(Regency data){

        MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue("id",data.getId());
        map.addValue("name",data.getName());
        map.addValue("province_id", data.getProvince_id());
        map.addValue("created_at",data.getCreated_at());
        jdbcTemplate.update(Query.CREATE_REGENCY,map);
        return data;
    }

    public List<Regency> list(){
        MapSqlParameterSource map = new MapSqlParameterSource();
        return jdbcTemplate.query(Query.LIST_REGENCY, map, new RowMapper<Regency>() {
            @Override
            public Regency mapRow(ResultSet resultSet, int i) throws SQLException {

                Regency regency = new Regency();
                regency.setId(resultSet.getString("id"));
                regency.setName(resultSet.getString("name"));
                regency.setCreated_at(resultSet.getDate("created_at"));
                regency.setUpdate_at(resultSet.getDate("update_at"));
                regency.setProvince_id(resultSet.getString("province_id"));

                Province province = new Province();
                province.setId(resultSet.getString("id_province"));
                province.setName(resultSet.getString("province_name"));
                province.setCreated_at(resultSet.getDate("province_created_at"));
                province.setUpdate_at(resultSet.getDate("province_update_at"));
                regency.setProvince_name(province);

                return regency;
            }
        });
    }

    public Regency getByid( String id){
        MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue("id", id);
        return jdbcTemplate.queryForObject(Query.REGENCY_GET_BY_ID, map, new RowMapper<Regency>() {
            @Override
            public Regency mapRow(ResultSet resultSet, int i) throws SQLException {

                Regency regency = new Regency();
                regency.setId(resultSet.getString("id"));
                regency.setName(resultSet.getString("name"));
                regency.setCreated_at(resultSet.getDate("created_at"));
                regency.setProvince_id(resultSet.getString("province_id"));

                Province province = new Province();
                province.setId(resultSet.getString("id_province"));
                province.setName(resultSet.getString("province_name"));
                province.setCreated_at(resultSet.getDate("province_created_at"));
                province.setUpdate_at(resultSet.getDate("province_update_at"));
                regency.setProvince_name(province);

                return  regency;
            }
        });
    }

    public Regency update(Regency data){

        MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue("id",data.getId());
        map.addValue("name",data.getName());
        map.addValue("province_id", data.getProvince_id());
        map.addValue("update_at",data.getUpdate_at());
        jdbcTemplate.update(Query.UPDATE_REGENCY,map);

        return data;
    }

    public void delete(String id){


        MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue("id", id);
        jdbcTemplate.update(Query.DELETE_REGENCY, map);
    }
}
