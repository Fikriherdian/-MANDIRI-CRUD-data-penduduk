package com.example.demo.controller;

import com.example.demo.Service.DistrictService;
import com.example.demo.model.District;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("api/district")
public class DistrictController {
    @Autowired
    private DistrictService districtService;

    @PostMapping("/")
    public ResponseEntity<District> create(
            @RequestBody District data
    ){
        return ResponseEntity.ok().body(districtService.create(data));
    }

    @GetMapping("/")
    public ResponseEntity<List<District>> list(){
        return ResponseEntity.ok().body(districtService.list());
    }

    @GetMapping("/{id}")
    public ResponseEntity <District> getByid(
            @PathVariable("id") String id
    ){
        return  ResponseEntity.ok().body((districtService.getById(id)));
    }

    @PutMapping("/")
    public ResponseEntity<District> update(
            @RequestBody District data
    ){
        return ResponseEntity.ok().body(districtService.update(data));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") String id
    ){
        String status = "status : id " + id + " tidak tersedia";
        for(District district : districtService.list()){
            if(district.getId().equals(id)){
                status = "status : id " + id + " berhasil dihapus";
            }
        }
        districtService.delete(id);
        return ResponseEntity.ok().body(status);
    }
}
