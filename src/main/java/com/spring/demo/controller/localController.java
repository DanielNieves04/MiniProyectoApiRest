/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.spring.demo.controller;

import com.spring.demo.entity.local;
import com.spring.demo.error.LocalNotFoundException;
import com.spring.demo.service.localService;
import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Francela Moreno
 */
@RestController
public class localController {
    
    @Autowired
    localService localService;
    
    //Exepciones
    @GetMapping("/findLocalById/{id}")
    local findLocalById(@PathVariable Long id) throws LocalNotFoundException {
        return localService.findLocalById(id);
    }
    
    @GetMapping("/findByNameIgnoreCase/{name}")
    Optional<local> findByNameIgnoreCase(@PathVariable String name){
        return localService.findByNameIgnoreCase(name);
    }
    
    @GetMapping("/findByName/{name}")
    Optional<local> findByName(@PathVariable String name){
        return localService.findByName(name);
    }
    
    @GetMapping("/findNameByWithJPQL/{name}")
    Optional<local> findLocalByNameWithJPQL(@PathVariable String name){
        return localService.findLocalByNameWithJPQL(name);
    }
    
    //Consultas
    @GetMapping("/findAllLocals")
    public List<local> findAllLocals(){
        return localService.finfAllLocals();
    }
    @PostMapping("/saveLocal")
    public local saveLocal(@Valid @RequestBody local local){
        return localService.saveLocal(local);
    }
    @PutMapping("/updateLocal/{id}")
    public local updateLocal(@PathVariable Long id,@RequestBody local local){
        return localService.updateLocal(id, local);
    }
    @DeleteMapping("/deleteLocal/{id}")
    public String deleteLocal(@PathVariable Long id){
        localService.deleteLocal(id);
        return "local $id deleting";
    }
    
}
