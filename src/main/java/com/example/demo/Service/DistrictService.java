package com.example.demo.Service;

import com.example.demo.model.District;
import com.example.demo.repository.DistrictRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
public class DistrictService {
    
    @Autowired
    DistrictRepository districtRepository;

    public District create(District data){
        LocalDateTime now = LocalDateTime.now();
        Date date = Timestamp.valueOf(now);
        data.setCreated_at(date);
        District district = districtRepository.create(data);
        return getById(data.getId());
    }
  
    public List<District> list(){
        return  districtRepository.list();
    }
  
      public District getById(String id){
          return  districtRepository.getByid(id);
      }
  
      public District update(District data){
          LocalDateTime now = LocalDateTime.now();
          Date date = Timestamp.valueOf(now);
          data.setUpdate_at(date);
          districtRepository.update(data);
          return getById(data.getId());
      }
  
      public void delete(String id){districtRepository.delete(id);}

}
