package com.example.demo.controller;

import com.example.demo.Service.PeopleService;
import com.example.demo.model.People;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("api/people")
public class PeopleController {
    @Autowired
    private PeopleService peopleService;

    @PostMapping("/")
    public ResponseEntity<People> create(
            @RequestBody People data
    ){
        return ResponseEntity.ok().body(peopleService.create(data));
    }

    @GetMapping("/")
    public ResponseEntity<List<People>> list(){
        return ResponseEntity.ok().body(peopleService.list());
    }

    @GetMapping("/{id}")
    public ResponseEntity <People> getByid(
            @PathVariable("id") String id
    ){
        return  ResponseEntity.ok().body((peopleService.getById(id)));
    }

    @PutMapping("/")
    public ResponseEntity<People> update(
            @RequestBody People data
    ){
        return ResponseEntity.ok().body(peopleService.update(data));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") String id
    ){
        String status = "status : id " + id + " tidak tersedia";
        for(People people : peopleService.list()){
            if(people.getId().equals(id)){
                status = "status : id " + id + " berhasil dihapus";
            }
        }
        peopleService.delete(id);
        return ResponseEntity.ok().body(status);
    }

    @GetMapping("/nama/{name}")
    public ResponseEntity<?> getByName(@PathVariable("name") String name
    ){

        return ResponseEntity.ok().body(peopleService.getByName(name));
    }

}
