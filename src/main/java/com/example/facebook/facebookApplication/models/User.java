package com.example.facebook.facebookApplication.models;

import lombok.*;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "user")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Valid
public class User implements Serializable {

    @Id
    @GeneratedValue
    @Column(name="id")
    private Integer id;

    @NotNull
    @NotEmpty
    @Column(name="userId")
    private String userId;

    @Column(name="name")
    private String name;

    @Column(name="emailId")
    @Email
    private String emailId;

    @Column(name="phoneNo")
    private String phoneNo;

    @Column(name="createdBy")
    private String createdBy;

    @Column(name="createdAt")
    private Date createdAt;

    @Column(name="updatedAt")
    private Date updatedAt;

    @Column(name="updatedBy")
    private String updatedBy;

}
