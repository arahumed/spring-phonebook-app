/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arthur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Features
 * - List All
 * - Add Person
 * - Remove Person
 * - Find Person
 * 
 * @author arahumed
 */
@Controller
public class PhonebookController {
    
    @Autowired
    PersonRepository repo;
    
    @RequestMapping("/call/listAll")
    public String listAll(Model model){
        model.addAttribute("listOfAllContacts", repo.findAll());
        return "allContacts"; // return name of view
    }

    @RequestMapping("/call/addContact")
    public String addContact(
            @ModelAttribute Person p,
            Model model){

        repo.save(p);
        
        model.addAttribute("person", p);
        return "addedContact"; // return name of view
    }
    
    @RequestMapping("/call/deleteContact")
    public String deleteContact(@RequestParam(value="id") long id, Model model){
        repo.delete(id);
        model.addAttribute("listOfAllContacts", repo.findAll());
        return "allContacts";
    }
    
    
    @RequestMapping("/call/editContact")
    public String editContact(@RequestParam(value="id") long id, Model model){
        Person p = repo.findOne(id);
        model.addAttribute("person", p);
        return "editContact";
    }
    
    @RequestMapping("/call/saveContact")
    public String saveContact(
            //@RequestParam(value="id") long id, 
            @ModelAttribute Person p,
            Model model){
        
        repo.save(p);
                
        model.addAttribute("person", p);
        return "addedContact";
    }    

}
