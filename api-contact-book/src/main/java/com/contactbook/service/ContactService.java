package com.contactbook.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.contactbook.exception.BusinessException;
import com.contactbook.model.Contact;
import com.contactbook.repository.ContactRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactService {
    
    @Autowired
    private ContactRepository repository;

    @Transactional
    public Contact save(Contact contact){
        return this.repository.save(contact);
    }

    @Transactional
    public Contact update(Contact contact){
        Contact persistedContact = this.findById(contact.getId());
        persistedContact.setName(contact.getName());
        persistedContact.setEmail(contact.getEmail());
        persistedContact.setPhoneNumber(contact.getPhoneNumber());
        return this.repository.save(persistedContact);
    }

    @Transactional
    public void delete(Integer id){
        Contact contact = this.findById(id);
        this.repository.delete(contact);
    }

    @Transactional
    public void deleteByIdUser(Integer idUser){
        this.repository.deleteByIdUser(idUser);
    }

    public Contact findById(Integer id){
        Optional<Contact> optionalContact = this.repository.findById(id);
        if(!optionalContact.isPresent()){
            throw new BusinessException("Contact not foud.");
        }
        return optionalContact.get();
    }

    public List<Contact> findAll(){
        return this.repository.findAll();
    }

    public List<Contact> findAllByidUser(Integer idUser){
        return this.repository.findAllByidUser(idUser);
    }

}
