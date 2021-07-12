package com.twologinpages.model.user;

import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "User")
@Table(name = "User", schema = "twologinpages")
public class User implements Serializable {

    // Это ID пользователя
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    // Это email пользователя
    @NaturalId
    @Column(name = "email", nullable = false, unique = true, length = 45)
    private String email;

    // Это пароль пользователя
    @Column(name = "password", nullable = false, length = 65)
    private String password;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
