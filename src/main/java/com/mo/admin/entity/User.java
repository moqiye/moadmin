package com.mo.admin.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import org.hibernate.annotations.Table;

import java.io.Serializable;

@Schema(
        description = "User Model Information"
)
@Data
@Table(appliesTo = "sys_user")
@Entity(name ="sys_user")
public class User implements Serializable {

    @Schema(
            description = "用户唯一标识"
    )
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Schema(
            description = "用户名"
    )
    @NotEmpty(message = "用户名不能为空")
    @Column(name="username")
    private String username;


    @Schema(
            description = "电子邮件"
    )
    @NotEmpty(message = "电子邮件并不能为空")
    @Email(message = "电子邮件并不能为空")
    @Column(name="email")
    private String email;

    @Column(name="phone")
    private String phone;
}
