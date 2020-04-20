package com.example.facebook.facebookApplication.service;

import com.example.facebook.facebookApplication.models.*;
import com.example.facebook.facebookApplication.repository.PostRepository;
import com.example.facebook.facebookApplication.utils.TransformationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PostService {

    @Autowired
    PostRepository postRepository;

    public PostResponse save(PostRequest postRequest) {

        Post post = TransformationUtils.toDao(postRequest);
        return TransformationUtils.toDto(postRepository.save(post));

    }

    public void delete(String postId){
        postRepository.delete(postRepository.getByPostId(postId).get(0));
    }

}
