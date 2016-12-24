/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arthur;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author arahumed
 */
public interface PersonRepository extends CrudRepository<Person, Long> {
    
    List<Person> findByName(String name);
    
}
