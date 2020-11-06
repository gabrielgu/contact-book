package com.contactbook.repository;

import java.util.List;

import com.contactbook.model.Contact;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Integer> {
    
    public List<Contact> findAllByidUser(Integer idUser);
}
