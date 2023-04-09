package com.javaMadeEasy.Entertainment.Controller;


import com.javaMadeEasy.Entertainment.Responce.ResponseHandler;
import com.javaMadeEasy.Entertainment.Service.PostService;
import com.javaMadeEasy.Entertainment.authentication.AUth.AuthenticationRequest;
import com.javaMadeEasy.Entertainment.authentication.AUth.AuthenticationResponce;
import com.javaMadeEasy.Entertainment.authentication.AUth.AuthenticationService;
import com.javaMadeEasy.Entertainment.authentication.AUth.RegisterRequest;
import com.javaMadeEasy.Entertainment.authentication.user.User;
import com.javaMadeEasy.Entertainment.authentication.user.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private PostService postService;
    @Autowired
    private AuthenticationService service;



    @GetMapping("/posts")
    public ResponseEntity<Object> getPost() {
      return   ResponseHandler.responseBuilder("Posts Fetched Successfully", 200,postService.getPost());

    }

    @PostMapping("/user/register")
    public ResponseEntity<?> register(
            @RequestBody RegisterRequest request) {
         ResponseEntity.ok(service.register(request));
         return service.getSavedUSer(request);
    }


    @PostMapping("/user/authenticate")
    public ResponseEntity<AuthenticationResponce> authenticate (
            @RequestBody AuthenticationRequest request){
            return  ResponseEntity.ok(service.authenticate(request));
    }


//    User user = new User("firstName","lastName","samuekk@gmail.com","Mack44");


}
