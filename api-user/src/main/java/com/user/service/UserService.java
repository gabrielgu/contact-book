package com.user.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.user.exception.BusinessException;
import com.user.model.User;
import com.user.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    
    @Autowired
    private UserRepository repository;

    @Transactional
    public User save(User user) {
        this.verifyUserAlreadyExistsByUsernameOrEmail(user.getUsername(), user.getEmail());
        return this.repository.save(user);
    }

    @Transactional
    public User update(User user) {
        this.verifyUserExistsById(user.getId());
        return this.repository.save(user);
    }

    @Transactional
    public void deleteById(Integer id){
        this.repository.deleteById(id);
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

    private void verifyUserExistsById(Integer id){
        Optional<User> foundUser = this.repository.findById(id);
        if(!foundUser.isPresent()){
            throw new BusinessException("User not found.");
        }
    }

    private void verifyUserAlreadyExistsByUsernameOrEmail(String username, String email){
        if(this.repository.existsByUsernameOrEmail(username, email)){
            throw new BusinessException("Username or E-mail already exists.");
        }
    }

}
