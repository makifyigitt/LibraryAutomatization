package com.may.LibraryAutomatization.controller;

import com.may.LibraryAutomatization.core.BaseResponse;
import com.may.LibraryAutomatization.core.exceptions.UserNotFoundException;
import com.may.LibraryAutomatization.dto.UserDTO;
import com.may.LibraryAutomatization.dto.UserUpdateDTO;
import com.may.LibraryAutomatization.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userManager) {
        this.userService = userManager;
    }

    @GetMapping("/getall")
    public ResponseEntity<List<UserDTO>> getAllUsers(){
        return ResponseEntity.ok(userService.getAllUsers());
    }


    @GetMapping("{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable int id){
            return ResponseEntity.ok(userService.getUserById(id));
    }

    @PutMapping("/update/{id}")
    public BaseResponse updateUserById(@PathVariable int id,@Valid @PathVariable UserUpdateDTO userUpdateDTO){
        userService.updateUserById(id,userUpdateDTO);
        return new BaseResponse();
    }

    @GetMapping("/getallactive")
    public ResponseEntity<List<UserDTO>> getAllActiveUsers() {
        return ResponseEntity.ok(userService.getAllActiveUsers());
    }

}
