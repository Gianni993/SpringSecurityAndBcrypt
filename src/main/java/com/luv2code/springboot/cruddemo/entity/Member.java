package com.luv2code.springboot.cruddemo.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="members")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id")
    private String userId;

    @OneToMany(mappedBy = "member",
            cascade = {CascadeType.REMOVE})
    private List<Roles> roles;

    @Column(name="pw")
    private String pw;

    @Column(name="active")
    private boolean active;

    public Member() {
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "Member{" +
                "userId=" + userId +
                ", pw='" + pw + '\'' +
                ", active=" + active +
                '}';
    }
}

