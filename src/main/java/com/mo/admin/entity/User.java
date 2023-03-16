package com.mo.admin.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import org.hibernate.annotations.Table;

@Data
@Table(appliesTo = "sys_user")
@Entity(name ="sys_user")
public class User   {
    @Id
    private String id;
}
