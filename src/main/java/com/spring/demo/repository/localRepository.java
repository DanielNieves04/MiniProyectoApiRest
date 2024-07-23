/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.spring.demo.repository;

import com.spring.demo.entity.local;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

//Capa Acesso de datos, nos permite realizar consultas o persistencias a la base de datos
public interface localRepository extends JpaRepository<local,Long>{
    
    //consulta con JPQL, con depedencias
    @Query("SELECT l FROM local l WHERE l.name = :name")
    //Optional porque se espera que la consulta retorne un solo registro, en caso contrario
    // se puede colocar List
    Optional<local> findLocalByNameWithJPQL(String name);
    
    //consulta con inversion de control, servivcio que ofrece srpingBoot
    Optional<local> findByName(String name);
    
    //consulta con ignorar caso de mayusculas y minusculas
    Optional<local> findByNameIgnoreCase(String name);
}
