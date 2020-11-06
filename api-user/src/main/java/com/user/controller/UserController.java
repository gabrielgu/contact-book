package com.user.controller;

import java.util.List;

import javax.validation.Valid;

import com.user.dto.PersistUser;
import com.user.model.User;
import com.user.service.UserService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/user")
public class UserController {
    
    @Autowired
    private UserService service;

    @Autowired
    private ModelMapper modelMapper;
    
    @PostMapping
    public User save(@Valid @RequestBody PersistUser userDTO){
        User user = this.modelMapper.map(userDTO, User.class);
        return this.service.save(user);
    }

    @PutMapping(path = "/{id}")
    public User update(@Valid @RequestBody PersistUser userDTO, @PathVariable Integer id){
        User user = this.modelMapper.map(userDTO, User.class);
        user.setId(id);
        return this.service.update(user);
    }

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable Integer id){
        this.service.deleteById(id);
    }

    @GetMapping(path = "/{id}")
    public User findById(@PathVariable Integer id){
        return this.service.findById(id);
    }

    @GetMapping()
    public List<User> findAll(){
        return this.service.findAll();
    }
}
