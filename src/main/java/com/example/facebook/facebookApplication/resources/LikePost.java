package com.example.facebook.facebookApplication.resources;

import com.example.facebook.facebookApplication.models.GenericResponse;
import com.example.facebook.facebookApplication.service.LikePostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping
public class LikePost {
    @Autowired
    LikePostService likePostService;

    @RequestMapping(value="/likes/{userId}/{postId}",method=RequestMethod.POST)
    public GenericResponse likePost(@PathVariable final String userId,@PathVariable final String postId) {
       likePostService.addLike(userId,postId);
       return GenericResponse.builder()
               .code("aa")
               .message("SUCESS")
               .build();
    }

    @RequestMapping(value="/likes/post/{postId}",method = RequestMethod.GET)
    public GenericResponse GetAlllikesByUser(@PathVariable final String postId){
        return GenericResponse.builder()
                .data(likePostService.getAllLikesPost(postId))
                .code("200")
                .message("SUCCESS")
                .build();
    }

    @RequestMapping(value="/likes/{userId}",method = RequestMethod.GET)
    public GenericResponse GetAlllikesByPost(@PathVariable final String userId){
        return GenericResponse.builder()
                .data(likePostService.getAllLikesUser(userId))
                .code("200")
                .message("SUCCESS")
                .build();
    }
}
