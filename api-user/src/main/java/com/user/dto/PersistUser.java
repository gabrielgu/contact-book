package com.user.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class PersistUser {

    @NotNull(message = "Username can't be null.")
    @NotBlank(message = "Username can't be blank.")
    private String username;

    @NotNull(message = "Username can't be null.")
    @NotBlank(message = "Password can't be blank.")
    private String password;

    @NotNull(message = "Username can't be null.")
    @NotBlank(message = "E-mail can't be blank.")
    private String email;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }

}
