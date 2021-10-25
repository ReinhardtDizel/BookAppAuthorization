package com.example.bookappauthorization.Model;

import com.example.bookappauthorization.Tools.Crypto;

import javax.persistence.*;

@Entity
@Table(name = "user_security")
public class Security {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "user_password",nullable = false)
    protected String password;

    @Column(name = "user_login", nullable = false)
    protected String login;

    public int getId() {
        return id;
    }

    public String getPassword() {
        return Crypto.decrypt(this.password);
    }

    public void setPassword(String password) {
        this.password = Crypto.encrypt(password);
    }

    public String getLogin() {
        return Crypto.decrypt(this.login);
    }

    public void setLogin(String login) {
        this.login = Crypto.encrypt(login);
    }
}
