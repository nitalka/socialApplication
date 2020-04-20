package com.example.facebook.facebookApplication.models;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostResponse {
    private String description;
    private String userId;
    private int likeCount;
    private String postId;
}
