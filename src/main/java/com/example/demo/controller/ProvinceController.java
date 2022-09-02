package com.example.demo.controller;

import com.example.demo.Service.ProvinceService;
import com.example.demo.model.Province;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("api/province")
public class ProvinceController {
    @Autowired
    private ProvinceService provinceService;

    @PostMapping("/")
    public ResponseEntity<Province> create(
            @RequestBody Province data
    ){
     return ResponseEntity.ok().body(provinceService.create(data));
    }

    @GetMapping("/")
    public ResponseEntity<List<Province>> list(){
        return ResponseEntity.ok().body(provinceService.list());
    }

   @GetMapping("/{id}")
   public ResponseEntity<Province> getByid(
           @PathVariable("id") String id
   ){
        return  ResponseEntity.ok().body((provinceService.getById(id)));
   }

   @PutMapping("/")
   public ResponseEntity<Province> update(
           @RequestBody Province data
   ){
       return ResponseEntity.ok().body(provinceService.update(data));
   }

   @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") String id
   ){
    String status = "status : id " + id + " tidak tersedia";
    for(Province province : provinceService.list()){
        if(province.getId().equals(id)){
            status = "status : id " + id + " berhasil dihapus";
        }
    }
    provinceService.delete(id);
    return ResponseEntity.ok().body(status);
   }
}
