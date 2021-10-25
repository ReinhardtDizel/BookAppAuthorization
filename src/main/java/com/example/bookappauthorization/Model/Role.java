package com.example.bookappauthorization.Model;

import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Entity
@Table(name = "user_role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "role", nullable = false)
    @ColumnDefault("user")
    private String role;

    public int getId() {
        return id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) throws Exception {
        if(
                role == "admin" ||
                role == "user" ||
                role == "moderator" ||
                role == "owner"
        ) {
            this.role = role;
        }
        else if(role == "") {
            this.role = "user";
        }
        else
            throw new Exception("This role is not allowed " + role);
    }
}
