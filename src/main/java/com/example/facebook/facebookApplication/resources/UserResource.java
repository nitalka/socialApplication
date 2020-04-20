package com.example.facebook.facebookApplication.resources;


import com.example.facebook.facebookApplication.models.UserRequest;
import com.example.facebook.facebookApplication.models.UserResponse;
import com.example.facebook.facebookApplication.models.User;
import com.example.facebook.facebookApplication.service.UserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/user")
public class UserResource {

    @Autowired
    UserService userService;

    @RequestMapping(value="/all", method = RequestMethod.GET)
    @ApiOperation("Get all list of users")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    public List<User> getAll(){
        return userService.findAll();
    }





    @RequestMapping(value="/", method = RequestMethod.POST)
    @ApiOperation("add a new user")
    public UserResponse persist(@RequestBody final UserRequest userRequest){
       return userService.save(userRequest);
    }



}
