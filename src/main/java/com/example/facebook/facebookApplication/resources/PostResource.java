package com.example.facebook.facebookApplication.resources;

import com.example.facebook.facebookApplication.models.PostRequest;
import com.example.facebook.facebookApplication.models.PostResponse;
import com.example.facebook.facebookApplication.service.PostService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(value="/post")
public class PostResource {

    @Autowired
    PostService postService;

    @PostMapping(value="/")
    @ApiOperation("add a post")
    public PostResponse addPost(@RequestBody final PostRequest postRequest){
        return postService.save(postRequest);
    }

    @DeleteMapping(value="/{postId}")
    @ApiOperation("delete a post")
    public void deletePost(@PathVariable final String postId) {
        postService.delete(postId);
    }

}
