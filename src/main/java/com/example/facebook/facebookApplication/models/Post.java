package com.example.facebook.facebookApplication.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name="post")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Post {

    @Id
    @GeneratedValue
    @Column(name="id")
    private int id;

    @Column(name="postId")
    private String postId;

    @Column(name="description")
    private String description;

    @Column(name="userId")
    private String userId;

    @Column(name="createdAt")
    private Date createdAt;

    @Column(name="likeCount")
    private int likeCount;
}
