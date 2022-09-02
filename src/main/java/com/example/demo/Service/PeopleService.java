package com.example.demo.Service;

import com.example.demo.model.People;
import com.example.demo.repository.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
public class PeopleService {
    
    @Autowired
    PeopleRepository peopleRepository;

    public People create(People data){
        LocalDateTime now = LocalDateTime.now();
        Date date = Timestamp.valueOf(now);
        data.setCreated_at(date);
        People people = peopleRepository.create(data);
        peopleRepository.updateNIK();
        return getById(data.getId()); 
    }
  
    public List<People> list(){
        return  peopleRepository.list();
    }
  
      public People getById(String id){
          return  peopleRepository.getByid(id);
      }

      public People getByName(String name){ return peopleRepository.getByName(name);}
  
      public People update(People data){
          LocalDateTime now = LocalDateTime.now();
          Date date = Timestamp.valueOf(now);
          data.setUpdate_at(date);
          peopleRepository.update(data);
          return getById(data.getId());
      }
  
      public void delete(String id){peopleRepository.delete(id);}

}
