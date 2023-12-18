package com.imryuik.server.dto;

public class UserDTO {
    private Long id;

    private String name;
    private String surname;
    private String phone_number;

    private String username;

    private String email;

    public UserDTO() {
    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getSurname() {
        return this.surname;
    }

    public String getPhone_number() {
        return this.phone_number;
    }

    public String getUsername() {
        return this.username;
    }

    public String getEmail() {
        return this.email;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
