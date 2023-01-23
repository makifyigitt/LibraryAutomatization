package com.may.LibraryAutomatization.controller;

import com.may.LibraryAutomatization.core.BaseResponse;
import com.may.LibraryAutomatization.dto.UserCreateDTO;
import com.may.LibraryAutomatization.dto.UserDTO;
import com.may.LibraryAutomatization.dto.UserUpdateDTO;
import com.may.LibraryAutomatization.service.UserService;
import jakarta.validation.Valid;
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
    public ResponseEntity<UserDTO> getUserById(@PathVariable("id") int id){
            return ResponseEntity.ok(userService.getUserById(id));
    }

    @PutMapping("/update/{id}")
    public BaseResponse updateUserById(@PathVariable("id") int id,
                                       @RequestBody @Valid UserUpdateDTO userUpdateDTO){
        userService.updateUserById(id,userUpdateDTO);
        return new BaseResponse("Successfully");
    }

    @GetMapping("/getallactive")
    public ResponseEntity<List<UserDTO>> getAllActiveUsers() {
        return ResponseEntity.ok(userService.getAllActiveUsers());
    }

    @DeleteMapping("/delete/{id}")
    public BaseResponse deleteUser(@PathVariable("id") int id){
        userService.deleteUser(id);
        return new BaseResponse("Passive delete successfully");
    }

    @PatchMapping("/active/{id}")
    public BaseResponse toMakeActiveUser(@PathVariable("id") int id){
        userService.toMakeActiveUser(id);
        return new BaseResponse("now this id: "+ id +" is active");
    }
    @PostMapping("/create")
    public BaseResponse createUser(UserCreateDTO userCreateDTO){
        userService.createUser(userCreateDTO);
        return new BaseResponse("user creation successfully");
    }

}
