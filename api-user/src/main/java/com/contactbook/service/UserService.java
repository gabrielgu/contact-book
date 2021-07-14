package com.contactbook.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.contactbook.exception.BusinessException;
import com.contactbook.model.User;
import com.contactbook.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    
    @Autowired
    private UserRepository repository;

    @Autowired
    private UserProducer producer;

    @Transactional
    public User save(User user) {
        this.verifyUserAlreadyExistsByUsernameOrEmail(user.getUsername(), user.getEmail());
        return this.repository.save(user);
    }

    @Transactional
    public User update(User user) {
        User userFound = this.findById(user.getId());
        userFound.setUsername(user.getUsername());
        userFound.setEmail(user.getEmail());
        userFound.setPassword(user.getPassword());
        return this.repository.save(user);
    }

    @Transactional
    public void delete(Integer id){
        User userFound = this.findById(id);
        this.repository.delete(userFound);
        this.producer.userDeleted(userFound);
    }

    public User findById(Integer id){
        Optional<User> foundUser = this.repository.findById(id);
        if(!foundUser.isPresent()){
            throw new BusinessException("User not found.");
        }
        return foundUser.get();
    }

    public List<User> findAll(){
        return this.repository.findAll();
    }

    private void verifyUserAlreadyExistsByUsernameOrEmail(String username, String email){
        if(this.repository.existsByUsernameOrEmail(username, email)){
            throw new BusinessException("Username or E-mail already exists.");
        }
    }

}
