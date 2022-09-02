package com.example.demo.Service;

import com.example.demo.model.Regency;
import com.example.demo.repository.RegencyRepository;

import java.util.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegencyService {
    @Autowired
    RegencyRepository regencyRepository;

    public Regency create(Regency data){
        LocalDateTime now = LocalDateTime.now();
        Date date = Timestamp.valueOf(now);
        data.setCreated_at(date);
        Regency regency = regencyRepository.create(data);

        return getById(data.getId());
    }
  
    public List<Regency> list(){
        return  regencyRepository.list();
    }
  
      public Regency getById(String id){
          return  regencyRepository.getByid(id);
      }
  
      public Regency update(Regency data){
          LocalDateTime now = LocalDateTime.now();
          Date date = Timestamp.valueOf(now);
          data.setUpdate_at(date);
          regencyRepository.update(data);
          return getById(data.getId());
      }
  
      public void delete(String id){regencyRepository.delete(id);}

}
