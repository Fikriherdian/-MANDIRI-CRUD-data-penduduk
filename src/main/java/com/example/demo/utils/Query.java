package com.example.demo.utils;public interface
Query{
    //province
    String CREATE_PROVINCE = "INSERT INTO province (id,name,created_at) VALUES (:id,:name,:created_at)";
    String LIST_PROVINCE = "SELECT id,name,created_at,update_at FROM Province ORDER by id";
    String GET_BY_ID = "SELECT id,name,created_at,update_at FROM Province WHERE id = :id";
    String UPDATE_PROVINCE = "UPDATE province SET name = :name,update_at = :update_at WHERE id = :id ";
    String DELETE_PROVINCE = "DELETE FROM province WHERE id = :id";

    //regency
    String CREATE_REGENCY = "INSERT INTO regency (id,name,province_id,created_at) VALUES (:id,:name,:province_id,:created_at)";
    String LIST_REGENCY ="SELECT r.id,r.name,r.province_id,r.created_at,r.update_at,p.id as id_province,p.name as province_name,p.created_at as province_created_at,p.update_at as  province_update_at FROM Regency r join province p on r.province_id = p.id";
    String REGENCY_GET_BY_ID = "SELECT r.id,r.name,r.province_id,r.created_at,r.update_at,p.id as id_province,p.name as province_name,p.created_at as province_created_at,p.update_at as  province_update_at FROM Regency r join province p on r.province_id = p.id WHERE r.id = :id";
    String DELETE_REGENCY = "DELETE FROM regency WHERE id = :id";
    String UPDATE_REGENCY = "UPDATE regency SET name = :name, province_id = :province_id ,update_at = :update_at WHERE id = :id \n";
    //district
    String CREATE_DISTRICT = "INSERT INTO district (id,name,regency_id,created_at) VALUES (:id,:name,:regency_id,:created_at)";
    String LIST_DISTRICT ="SELECT r.id,r.name,r.regency_id,r.created_at,r.update_at,p.id as id_regency,p.name as regency_name,p.created_at as regency_created_at,p.update_at as  regency_update_at FROM District r join regency p on r.regency_id = p.id";
    String DISTRICT_GET_BY_ID = "SELECT r.id,r.name,r.regency_id,r.created_at,r.update_at,p.id as id_regency,p.name as regency_name,p.created_at as regency_created_at,p.update_at as  regency_update_at FROM District r join regency p on r.regency_id = p.id WHERE r.id = :id";
    String UPDATE_DISTRICT = "UPDATE district SET name = :name, regency_id = :regency_id,update_at = :update_at WHERE id = :id ";
    String DELETE_DISTRICT = "DELETE FROM district WHERE id = :id";

    //people

    String CREATE_PEOPLE = "insert\n" +
            "\tinto\n" +
            "\tpeople (id,\n" +
            "\tnik,\n" +
            "\tname,\n" +
            "\tgender,\n" +
            "\tdob,\n" +
            "\tpob,\n" +
            "\tprovince_id,\n" +
            "\tregency_id,\n" +
            "\tdistrict_id,\n" +
            "\tcreated_at)\n" +
            "values (:id,\n" +
            "concat(:province_id,:regency_id,:district_id,(select nik from nik_generator ng)),\n" +
            ":name,\n" +
            ":gender,\n" +
            ":dob,\n" +
            ":pob,\n" +
            ":province_id,\n" +
            ":regency_id,\n" +
            ":district_id,\n" +
            ":created_at)";
    String LIST_PEOPLE = "select\n" +
            "\tpe.id,\n" +
            "\tpe.nik,\n" +
            "\tpe.name,\n" +
            "\tpe.gender,\n" +
            "\tpe.dob,\n" +
            "\tpe.pob,\n" +
            "\tpe.province_id,\n" +
            "\tpe.regency_id,\n" +
            "\tpe.district_id,\n" +
            "\tpe.created_at,\n" +
            "\tpe.update_at,\n" +
            "\tp.id as id_province,\n" +
            "\tp.name as province_name,\n" +
            "\tp.created_at as province_created_at,\n" +
            "\tp.update_at as province_update_at,\n" +
            "\tr.id as id_regency,\n" +
            "\tr.name as regency_name,\n" +
            "\tr.province_id as regency_province_id,\n" +
            "\tr.created_at as regency_created_at,\n" +
            "\tr.update_at as regency_update_at,\n" +
            "\td.id as id_district,\n" +
            "\td.name as district_name,\n" +
            "\td.regency_id as district_regency_id,\n" +
            "\td.created_at as district_created_at,\n" +
            "\td.update_at as district_update_at\n" +
            "from\n" +
            "\tpeople pe\n" +
            "join province p on\n" +
            "\tpe.province_id = p.id\n" +
            "join regency r on\n" +
            "\tpe.regency_id = r.id\n" +
            "join district d on\n" +
            "\tpe.district_id = d.id\n";

    String PEOPLE_GET_BY_ID = "select\n" +
            "\tpe.id,\n" +
            "\tpe.nik,\n" +
            "\tpe.name,\n" +
            "\tpe.gender,\n" +
            "\tpe.dob,\n" +
            "\tpe.pob,\n" +
            "\tpe.province_id,\n" +
            "\tpe.regency_id,\n" +
            "\tpe.district_id,\n" +
            "\tpe.created_at,\n" +
            "\tpe.update_at,\n" +
            "\tp.id as id_province,\n" +
            "\tp.name as province_name,\n" +
            "\tp.created_at as province_created_at,\n" +
            "\tp.update_at as province_update_at,\n" +
            "\tr.id as id_regency,\n" +
            "\tr.name as regency_name,\n" +
            "\tr.province_id as regency_province_id,\n" +
            "\tr.created_at as regency_created_at,\n" +
            "\tr.update_at as regency_update_at,\n" +
            "\td.id as id_district,\n" +
            "\td.name as district_name,\n" +
            "\td.regency_id as district_regency_id,\n" +
            "\td.created_at as district_created_at,\n" +
            "\td.update_at as district_update_at\n" +
            "from\n" +
            "\tpeople pe\n" +
            "join province p on\n" +
            "\tpe.province_id = p.id\n" +
            "join regency r on\n" +
            "\tpe.regency_id = r.id\n" +
            "join district d on\n" +
            "\tpe.district_id = d.id\n" +
            "where\n" +
            "\tpe.id = :id";
    String UPDATE_PEOPLE = "UPDATE people SET name = :name,gender = :gender, dob = :dob, pob = :pob, province_id = :province_id, regency_id = :regency_id, district_id = :district_id, update_at = :update_at WHERE id = :id ";
    String DELETE_PEOPLE = "DELETE FROM people WHERE id = :id";

    String UPDATE_NIK = "update nik_generator set nik = concat((" +
            "case\n" +
            "when substring(nik,1,4) = '0000' and substring(nik,5,1) <> '9'\n" +
            "then '0000'\n" +
            "\n" +
            "when (substring(nik,1,4) = '0000' and substring(nik,5,1) = '9')\n" +
            "or (substring(nik,1,3) = '000' and substring(nik,4,2) <> '99')\n" +
            "then '000' \n" +
            "\n" +
            "when (substring(nik,1,3) = '000' and substring(nik,4,2) = '99')\n" +
            "or (substring(nik,1,2) = '00' and substring(nik,3,3) <> '999')\n" +
            "then '00' \n" +
            "\n" +
            "when (substring(nik,1,2) = '00' and substring(nik,3,3) = '999')\n" +
            "or (substring(nik,1,1) = '0' and substring(nik,2,4) <> '9999')\n" +
            "then '0'\n" +
            "\n" +
            "else ''\n" +
            "\n" +
            "end),cast(cast(nik as integer)+1 as varchar)) ";

    String PEOPLE_GET_BY_NAME ="select\n" +
            "\tpe.id,\n" +
            "\tpe.nik,\n" +
            "\tpe.name,\n" +
            "\tpe.gender,\n" +
            "\tpe.dob,\n" +
            "\tpe.pob,\n" +
            "\tpe.province_id,\n" +
            "\tpe.regency_id,\n" +
            "\tpe.district_id,\n" +
            "\tpe.created_at,\n" +
            "\tpe.update_at,\n" +
            "\tp.id as id_province,\n" +
            "\tp.name as province_name,\n" +
            "\tp.created_at as province_created_at,\n" +
            "\tp.update_at as province_update_at,\n" +
            "\tr.id as id_regency,\n" +
            "\tr.name as regency_name,\n" +
            "\tr.province_id as regency_province_id,\n" +
            "\tr.created_at as regency_created_at,\n" +
            "\tr.update_at as regency_update_at,\n" +
            "\td.id as id_district,\n" +
            "\td.name as district_name,\n" +
            "\td.regency_id as district_regency_id,\n" +
            "\td.created_at as district_created_at,\n" +
            "\td.update_at as district_update_at\n" +
            "from\n" +
            "\tpeople pe\n" +
            "join province p on\n" +
            "\tpe.province_id = p.id\n" +
            "join regency r on\n" +
            "\tpe.regency_id = r.id\n" +
            "join district d on\n" +
            "\tpe.district_id = d.id\n" +
            "where\n" +
            "\tpe.name ilike concat('%',:name,'%')";
}
