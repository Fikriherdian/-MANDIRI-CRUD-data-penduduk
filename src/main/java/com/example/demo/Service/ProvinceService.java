package com.example.demo.Service;

import com.example.demo.model.Province;
import com.example.demo.repository.ProvinceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
public class ProvinceService {

  @Autowired
    private ProvinceRepository provinceRepository;

  public Province create(Province data){
      LocalDateTime now = LocalDateTime.now();
      Date date = Timestamp.valueOf(now);
      data.setCreated_at(date);
      return provinceRepository.create(data);
  }

  public List<Province> list(){
      return  provinceRepository.list();
  }

    public Province getById(String id){
        return  provinceRepository.getByid(id);
    }

    public Province update(Province data){
        LocalDateTime now = LocalDateTime.now();
        Date date = Timestamp.valueOf(now);
        data.setUpdate_at(date);
      return provinceRepository.update(data);
    }

    public void delete(String id){provinceRepository.delete(id);}
}
