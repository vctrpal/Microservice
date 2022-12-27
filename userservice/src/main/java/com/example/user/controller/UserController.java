package com.example.user.controller;

import com.example.user.VO.ResponseTemplateVO;
import com.example.user.entity.UserDetail;
import com.example.user.service.UserService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private static final String USER_SERVICE = "userService";
    @Autowired
    UserService userService;

    //private final ExecutorService traceableExecutorService;

    @PostMapping("/")
    public UserDetail saveUser(@RequestBody UserDetail user){
        return userService.saveUser(user);
    }
    @GetMapping("/{id}")
    @CircuitBreaker(name=USER_SERVICE, fallbackMethod = "userFallback")
    public ResponseEntity<Object> getUserWithDepartment(@PathVariable("id") Long userId){

            //throw new RuntimeException("its not working");
        return new ResponseEntity<Object>(userService.getUserWithDepartment(userId), HttpStatus.OK);

    }

    public ResponseEntity<Object> userFallback(Exception e){
        return new ResponseEntity<Object>("department service is down", HttpStatus.OK);

    }
}
