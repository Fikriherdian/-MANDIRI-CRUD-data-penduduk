package com.example.demo.repository;

import com.example.demo.model.District;
import com.example.demo.model.People;
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
public class PeopleRepository {
    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;

    public People create(People data){
        MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue("id",data.getId());
        map.addValue("name",data.getName());
//        map.addValue("nik" , data.getNik());
        map.addValue("gender",data.getGender());
        map.addValue("dob",data.getDob());
        map.addValue("pob",data.getPob());
        map.addValue("province_id", data.getProvince_id());
        map.addValue("regency_id", data.getRegency_id());
        map.addValue("district_id", data.getDistrict_id() );
        map.addValue("created_at",data.getCreated_at());
        jdbcTemplate.update(Query.CREATE_PEOPLE,map);
        return data;
    }

    public List<People> list(){


        MapSqlParameterSource map = new MapSqlParameterSource();
        return jdbcTemplate.query(Query.LIST_PEOPLE, map, new RowMapper<People>() {
            @Override
            public People mapRow(ResultSet resultSet, int i) throws SQLException {

                People people = new People();
                people.setId(resultSet.getString("id"));
                people.setName(resultSet.getString("name"));
                people.setNik(resultSet.getString("nik"));
                people.setGender(resultSet.getString("gender"));
                people.setDob(resultSet.getDate("dob"));
                people.setPob(resultSet.getString("pob"));
                people.setProvince_id(resultSet.getString("province_id"));
                people.setRegency_id(resultSet.getString("regency_id"));
                people.setDistrict_id(resultSet.getString("district_id"));
                people.setCreated_at(resultSet.getDate("created_at"));
                people.setUpdate_at(resultSet.getDate("update_at"));

                Province province = new Province();
                province.setId(resultSet.getString("id_province"));
                province.setName(resultSet.getString("province_name"));
                province.setCreated_at(resultSet.getDate("province_created_at"));
                province.setUpdate_at(resultSet.getDate("province_update_at"));
                people.setProvince(province);

                Regency regency = new Regency();
                regency.setId(resultSet.getString("id_regency"));
                regency.setName(resultSet.getString("regency_name"));
                regency.setProvince_id(resultSet.getString("regency_province_id"));
                regency.setCreated_at(resultSet.getDate("regency_created_at"));
                regency.setUpdate_at(resultSet.getDate("regency_update_at"));
                people.setRegency(regency);

                District district = new District();
                district.setId(resultSet.getString("id_district"));
                district.setName(resultSet.getString("district_name"));
                district.setRegency_id(resultSet.getString("district_regency_id"));
                district.setCreated_at(resultSet.getDate("district_created_at"));
                district.setUpdate_at(resultSet.getDate("district_update_at"));
                people.setDistrict(district);

                return people;
            }
        });
    }

    public  People getByid(String id){
        MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue("id",id);
        return  jdbcTemplate.queryForObject(Query.PEOPLE_GET_BY_ID, map, new RowMapper<People>() {
            @Override
            public People mapRow(ResultSet resultSet, int i) throws SQLException {

                People people = new People();
                people.setId(resultSet.getString("id"));
                people.setNik(resultSet.getString("nik"));
                people.setName(resultSet.getString("name"));
                people.setGender(resultSet.getString("gender"));
                people.setDob(resultSet.getDate("dob"));
                people.setPob(resultSet.getString("pob"));
                people.setProvince_id(resultSet.getString("province_id"));
                people.setRegency_id(resultSet.getString("regency_id"));
                people.setDistrict_id(resultSet.getString("district_id"));
                people.setCreated_at(resultSet.getDate("created_at"));
                people.setUpdate_at(resultSet.getDate("update_at"));

                Province province = new Province();
                province.setId(resultSet.getString("id_province"));
                province.setName(resultSet.getString("province_name"));
                province.setCreated_at(resultSet.getDate("province_created_at"));
                province.setUpdate_at(resultSet.getDate("province_update_at"));
                people.setProvince(province);

                Regency regency = new Regency();
                regency.setId(resultSet.getString("id_regency"));
                regency.setName(resultSet.getString("regency_name"));
                regency.setProvince_id(resultSet.getString("regency_province_id"));
                regency.setCreated_at(resultSet.getDate("regency_created_at"));
                regency.setUpdate_at(resultSet.getDate("regency_update_at"));
                people.setRegency(regency);

                District district = new District();
                district.setId(resultSet.getString("id_district"));
                district.setName(resultSet.getString("district_name"));
                district.setRegency_id(resultSet.getString("district_regency_id"));
                district.setCreated_at(resultSet.getDate("district_created_at"));
                district.setUpdate_at(resultSet.getDate("district_update_at"));
                people.setDistrict(district);

                return people;
            }
        });
    }

    public People getByName(String nama){
        MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue("name",nama);
        return  jdbcTemplate.queryForObject(Query.PEOPLE_GET_BY_NAME, map, new RowMapper<People>() {
            @Override
            public People mapRow(ResultSet resultSet, int i) throws SQLException {

                People people = new People();
                people.setId(resultSet.getString("id"));
                people.setNik(resultSet.getString("nik"));
                people.setName(resultSet.getString("name"));
                people.setGender(resultSet.getString("gender"));
                people.setDob(resultSet.getDate("dob"));
                people.setPob(resultSet.getString("pob"));
                people.setProvince_id(resultSet.getString("province_id"));
                people.setRegency_id(resultSet.getString("regency_id"));
                people.setDistrict_id(resultSet.getString("district_id"));
                people.setCreated_at(resultSet.getDate("created_at"));
                people.setUpdate_at(resultSet.getDate("update_at"));

                Province province = new Province();
                province.setId(resultSet.getString("id_province"));
                province.setName(resultSet.getString("province_name"));
                province.setCreated_at(resultSet.getDate("province_created_at"));
                province.setUpdate_at(resultSet.getDate("province_update_at"));
                people.setProvince(province);

                Regency regency = new Regency();
                regency.setId(resultSet.getString("id_regency"));
                regency.setName(resultSet.getString("regency_name"));
                regency.setProvince_id(resultSet.getString("regency_province_id"));
                regency.setCreated_at(resultSet.getDate("regency_created_at"));
                regency.setUpdate_at(resultSet.getDate("regency_update_at"));
                people.setRegency(regency);

                District district = new District();
                district.setId(resultSet.getString("id_district"));
                district.setName(resultSet.getString("district_name"));
                district.setRegency_id(resultSet.getString("district_regency_id"));
                district.setCreated_at(resultSet.getDate("district_created_at"));
                district.setUpdate_at(resultSet.getDate("district_update_at"));
                people.setDistrict(district);

                return people;
            }
        });
    }

    public People update(People data){

        MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue("id",data.getId());
        map.addValue("name",data.getName());
        map.addValue("gender",data.getGender());
        map.addValue("dob",data.getDob());
        map.addValue("pob",data.getPob());
        map.addValue("province_id", data.getProvince_id());
        map.addValue("regency_id", data.getRegency_id());
        map.addValue("district_id", data.getDistrict_id());
        map.addValue("update_at",data.getUpdate_at());
        jdbcTemplate.update(Query.UPDATE_PEOPLE,map);
        return data;
    }

    public void updateNIK(){
        MapSqlParameterSource map = new MapSqlParameterSource();
        jdbcTemplate.update(Query.UPDATE_NIK, map);
    }

    public void delete(String id){


        MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue("id", id);
        jdbcTemplate.update(Query.DELETE_PEOPLE, map);
    }

}
