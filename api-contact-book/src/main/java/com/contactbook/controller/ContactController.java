package com.contactbook.controller;

import java.util.List;

import javax.validation.Valid;

import com.contactbook.dto.PostContactDTO;
import com.contactbook.dto.PutContactDTO;
import com.contactbook.model.Contact;
import com.contactbook.service.ContactService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactController {
    
    @Autowired
    private ContactService service;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping(path = "/contact")
    public Contact save(@Valid @RequestBody PostContactDTO contactDTO){
        Contact contact = this.modelMapper.map(contactDTO, Contact.class);
        return this.service.save(contact);
    }

    @PutMapping(path = "/contact/{id}")
    public Contact update(@Valid @RequestBody PutContactDTO contactDTO, 
        @PathVariable Integer id){
        Contact contact = this.modelMapper.map(contactDTO, Contact.class);
        contact.setId(id);
        return this.service.update(contact);
    }

    @DeleteMapping(path = "/contact/{id}")
    public void delete(@PathVariable Integer id){
        this.service.delete(id);
    }

    @GetMapping(path = "/contact/{id}")
    public Contact findById(@PathVariable Integer id){
        return this.service.findById(id);
    }

    @GetMapping(path = "/contact")
    public List<Contact> findAll(){
        return this.service.findAll();
    }

    @GetMapping(path = "/user/{idUser}/contact")
    public List<Contact> findAllByIdUser(@PathVariable Integer idUser){
        return this.service.findAllByidUser(idUser);
    }

}
