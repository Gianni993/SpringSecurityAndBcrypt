package com.luv2code.springboot.cruddemo.entity;

import jakarta.persistence.*;

@Entity
@Table(name="roles")
public class Roles {

    @Id
    @ManyToOne
    @JoinColumn(name="user_id")
    private Member member;

    @Column(name="role")
    private String role;

    public Roles() {
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Roles{" +

                ", role='" + role + '\'' +
                '}';
    }
}
