package com.imryuik.server.entity;

import jakarta.persistence.*;
import lombok.NonNull;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String surname;
    private String phone_number;

    @Column(unique = true)
    private String username;

    @Column(unique = true)
    private String email;


    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;
    

    public User(Long id, String name, String surname, String phone_number,  String username,  String email,  String password, Role role) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.phone_number = phone_number;
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public User() {
        this.username = null;
        this.email = null;
        this.password = null;
    }

    public static UserBuilder builder() {
        return new UserBuilder();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
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

    public String getPassword() {
        return this.password;
    }

    public Role getRole() {
        return this.role;
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

    public void setUsername( String username) {
        this.username = username;
    }

    public void setEmail( String email) {
        this.email = email;
    }

    public void setPassword( String password) {
        this.password = password;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public static class UserBuilder {
        private Long id;
        private String name;
        private String surname;
        private String phone_number;
        private  String username;
        private  String email;
        private  String password;
        private Role role;

        UserBuilder() {
        }

        public UserBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public UserBuilder name(String name) {
            this.name = name;
            return this;
        }

        public UserBuilder surname(String surname) {
            this.surname = surname;
            return this;
        }

        public UserBuilder phone_number(String phone_number) {
            this.phone_number = phone_number;
            return this;
        }

        public UserBuilder username( String username) {
            this.username = username;
            return this;
        }

        public UserBuilder email( String email) {
            this.email = email;
            return this;
        }

        public UserBuilder password( String password) {
            this.password = password;
            return this;
        }

        public UserBuilder role(Role role) {
            this.role = role;
            return this;
        }

        public User build() {
            return new User(this.id, this.name, this.surname, this.phone_number, this.username, this.email, this.password, this.role);
        }

        public String toString() {
            return "User.UserBuilder(id=" + this.id + ", name=" + this.name + ", surname=" + this.surname + ", phone_number=" + this.phone_number + ", username=" + this.username + ", email=" + this.email + ", password=" + this.password + ", role=" + this.role + ")";
        }
    }
}
