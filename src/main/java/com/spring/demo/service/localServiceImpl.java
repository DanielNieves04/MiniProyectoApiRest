/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.spring.demo.service;

import com.spring.demo.entity.local;
import com.spring.demo.error.LocalNotFoundException;
import com.spring.demo.repository.localRepository;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Francela Moreno
 */
@Service    
public class localServiceImpl implements localService{
    
    @Autowired
    localRepository localRepository;
    
    @Override
    public List<local> finfAllLocals() {
        return localRepository.findAll();
    }

    @Override
    public local saveLocal(local local) {
        return localRepository.save(local);
    }

    @Override
    public local updateLocal(Long id, local local) {
        local localbd = localRepository.findById(id).get();
        if(Objects.nonNull(local.getCode()) && !"".equalsIgnoreCase(local.getCode())){
            localbd.setCode(local.getCode());
        }
        if(Objects.nonNull(local.getFloor()) && !"".equalsIgnoreCase(local.getFloor())){
            localbd.setFloor(local.getFloor());
        }
        if(Objects.nonNull(local.getName()) && !"".equalsIgnoreCase(local.getName())){
            localbd.setName(local.getName());
        }
        return localRepository.save(localbd);
    }

    @Override
    public void deleteLocal(Long id) {
        localRepository.deleteById(id);
    }

    @Override
    public Optional<local> findLocalByNameWithJPQL(String name) {
        return localRepository.findLocalByNameWithJPQL(name);
    }

    @Override
    public Optional<local> findByName(String name) {
        return localRepository.findByName(name);
    }

    @Override
    public Optional<local> findByNameIgnoreCase(String name) {
        return localRepository.findByNameIgnoreCase(name);
    }

    @Override
    public local findLocalById(Long id) throws LocalNotFoundException{
        Optional<local> local = localRepository.findById(id);
        if(!local.isPresent()){
            throw new LocalNotFoundException("Local is not available");
        }
        return local.get();
    }
}
