package com.contactbook.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class PostContactDTO {
    
    @NotNull(message = "Contact name can't be null.")
    @NotBlank(message = "Contact name can't be blank.")
    private String name;

    @NotNull(message = "Contact email can't be null.")
    @NotBlank(message = "Contact email can't be blank.")
    private String email;

    @NotNull(message = "Contact phone number can't be null.")
    @NotBlank(message = "Contact phone number can't be blank.")
    private String phoneNumber;

    @NotNull(message = "Contact user number can't be null.")
    private Integer idUser;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

}
