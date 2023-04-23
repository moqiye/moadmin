package com.mo.admin.entity;

import cn.hutool.core.lang.UUID;
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
    private String id = UUID.randomUUID().toString(true);
    @Column(name="username")
    private String username;
    @Column(name="email")
    private String email;
    @Column(name="phone")
    private String phone;
}
