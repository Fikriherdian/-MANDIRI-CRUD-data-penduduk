package com.example.demo.controller;

import com.example.demo.Service.RegencyService;
import com.example.demo.model.Regency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("api/regency")
public class RegencyController {
    @Autowired
    private RegencyService regencyService;

    @PostMapping("/")
    public ResponseEntity<Regency> create(
            @RequestBody Regency data
    ){
     return ResponseEntity.ok().body(regencyService.create(data));
    }

    @GetMapping("/")
    public ResponseEntity<List<Regency>> list(){
        return ResponseEntity.ok().body(regencyService.list());
    }

   @GetMapping("/{id}")
   public ResponseEntity <Regency> getByid(
           @PathVariable("id") String id
   ){
        return  ResponseEntity.ok().body((regencyService.getById(id)));
   }

   @PutMapping("/")
   public ResponseEntity<Regency> update(
           @RequestBody Regency data
   ){
       return ResponseEntity.ok().body(regencyService.update(data));
   }

   @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") String id
   ){
    String status = "status : id " + id + " tidak tersedia";
    for(Regency regency : regencyService.list()){
        if(regency.getId().equals(id)){
            status = "status : id " + id + " berhasil dihapus";
        }
    }
    regencyService.delete(id);
    return ResponseEntity.ok().body(status);
   }
}
