package com.may.LibraryAutomatization.service;

import com.may.LibraryAutomatization.core.exceptions.UserNotFoundException;
import com.may.LibraryAutomatization.dto.UserDTO;
import com.may.LibraryAutomatization.model.user.User;
import com.may.LibraryAutomatization.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {
    private UserService userService;
    private UserRepository userRepository;

    @BeforeEach
    void setUp() {
        userRepository = Mockito.mock(UserRepository.class);
        userService = new UserService(userRepository);
    }

    @Test
    public void testFindUserById_whenUserIdExist_shouldReturnUser(){
        User user = new User(111,"name","surname",1, List.of(),List.of(),List.of());
        Mockito.when(userRepository.findById(111)).thenReturn(Optional.of(user));

        User result = userService.findUserById(111);

        assertEquals(result,user);
    }

    @Test
    public void testFindUserById_whenUserIdDoesNotExist_shouldThrowUserNotFoundException(){
        Mockito.when(userRepository.findById(111)).thenReturn(Optional.empty());
        assertThrows(UserNotFoundException.class,()-> userService.findUserById(111));
    }

    @Test
    public void testGetUserById_whenUserIdExist_shouldReturnUser(){
        User user = new User(111,"name","surname",1, List.of(),List.of(),List.of());
        UserDTO userDTO = new UserDTO(user);
        Mockito.when(userRepository.findById(111)).thenReturn(Optional.of(user));

        UserDTO result = userService.getUserById(111);

        assertEquals(result,userDTO);
    }

    @Test
    public void testGetUserById_whenUserIdDoesNotExist_shouldThrowUserNotFoundException(){
        Mockito.when(userRepository.findById(111)).thenReturn(Optional.empty());
        assertThrows(UserNotFoundException.class,()-> userService.getUserById(111));
    }


}