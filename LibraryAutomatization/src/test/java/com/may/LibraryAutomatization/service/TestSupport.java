package com.may.LibraryAutomatization.service;

import com.may.LibraryAutomatization.dto.UserCreateDTO;
import com.may.LibraryAutomatization.dto.UserDTO;
import com.may.LibraryAutomatization.model.user.Address;
import com.may.LibraryAutomatization.model.user.Email;
import com.may.LibraryAutomatization.model.user.PhoneNumber;
import com.may.LibraryAutomatization.model.user.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TestSupport {

    public static List<User> generateUserList(){
        return IntStream.range(0,5)
                .mapToObj(i -> new User(i,
                        "firstName"+i,
                        "lastName"+i,
                        new Random(2).nextInt(),
                        List.of(),
                        List.of(),
                        List.of(),
                        List.of(),
                        List.of()))
                .collect(Collectors.toList());
    }

    public static List<UserDTO> generateUserDtoList(List<User> userList){
        return userList.stream().map(UserDTO::new).collect(Collectors.toList());
    }


}
