/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.spring.demo.service;

import com.spring.demo.entity.local;
import com.spring.demo.error.LocalNotFoundException;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Francela Moreno
 */
public interface localService {
    List<local> finfAllLocals();
    local saveLocal(local local);
    local updateLocal(Long id,local local);
    void deleteLocal(Long id);
    Optional<local> findLocalByNameWithJPQL(String name);
    Optional<local> findByName(String name);
    Optional<local> findByNameIgnoreCase(String name);
    local findLocalById(Long id) throws LocalNotFoundException;
}
