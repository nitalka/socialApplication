package com.example.facebook.facebookApplication.utils;

import com.example.facebook.facebookApplication.models.*;

import java.util.Date;
import java.util.UUID;

public class TransformationUtils {

    private TransformationUtils() throws Exception {
        throw new Exception("Cant create object");
    }

    public static User toDao(UserRequest userRequest) {
        return User.builder()
                .createdAt(new Date())
                .createdBy(userRequest.getName())
                .phoneNo(userRequest.getPhoneNo())
                .userId(UUID.randomUUID().toString())
                .name(userRequest.getName())
                .emailId(userRequest.getEmailId())
                .build();

    }

    public static UserResponse toDto(User user) {
        return UserResponse.builder()
                    .userId(user.getUserId())
                    .name(user.getName())
                    .phoneNo(user.getPhoneNo())
                    .emailId(user.getEmailId())
                    .build();
    }


    public static Post toDao(PostRequest postRequest) {
        return Post.builder()
                .createdAt(new Date())
                .postId(UUID.randomUUID().toString())
                .description(postRequest.getDescription())
                .likeCount(0)
                .userId(postRequest.getUserId())
                .build();

    }

    public static PostResponse toDto(Post post) {
        return PostResponse.builder()
                .userId(post.getUserId())
                .description(post.getDescription())
                .postId(post.getPostId())
                .likeCount(post.getLikeCount())
                .build();
    }
}
