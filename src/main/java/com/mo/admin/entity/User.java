package com.mo.admin.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Table;

import java.io.Serializable;

@Data
@Table(appliesTo = "sys_user")
@Entity(name ="sys_user")
public class User implements Serializable {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(name="username")
    private String username;
    @Column(name="email")
    private String email;
    @Column(name="phone")
    private String phone;
}
