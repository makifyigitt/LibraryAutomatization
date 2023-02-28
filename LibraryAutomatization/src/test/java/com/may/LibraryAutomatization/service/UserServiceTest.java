package com.may.LibraryAutomatization.service;

import com.may.LibraryAutomatization.core.exceptions.UserNotFoundException;
import com.may.LibraryAutomatization.dto.UserDTO;
import com.may.LibraryAutomatization.dto.UserUpdateDTO;
import com.may.LibraryAutomatization.model.user.Address;
import com.may.LibraryAutomatization.model.user.Email;
import com.may.LibraryAutomatization.model.user.PhoneNumber;
import com.may.LibraryAutomatization.model.user.User;
import com.may.LibraryAutomatization.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest{
    private UserService userService;
    private UserRepository userRepository;

    private BlackListService blackListService;

    @BeforeEach
    void setUp() {
        userRepository = Mockito.mock(UserRepository.class);
        userService = new UserService(userRepository);
    }
    @Test
    public void testGetAllUsers_shouldReturnUserDTOList(){

        User user = new User(111,"name","surname",1, List.of(),List.of(),List.of(),List.of(),List.of());
        User user1 = new User(222,"name","surname",0, List.of(),List.of(),List.of(),List.of(),List.of());
        User user2 = new User(222,"name","surname",1, List.of(),List.of(),List.of(),List.of(),List.of());
        List<User> userList = userRepository.findAll();
        List<UserDTO> userDTOList = userList.stream().map(UserDTO::new).collect(Collectors.toList());

        Mockito.when(userRepository
                    .findAll()
                    .stream()
                    .map(UserDTO::new)
                    .collect(Collectors.toList()))
                .thenReturn(userDTOList);

        List<UserDTO> result = userService.getAllUsers();

        assertEquals(result,userDTOList);

        Mockito.verify(userRepository).findAll();

    }

    @Test
    public void testFindUserById_whenUserIdExist_shouldReturnUser(){
        User user = new User(111,"name","surname",1, List.of(),List.of(),List.of(),List.of(),List.of());

        Mockito.when(userRepository.findById(111)).thenReturn(Optional.of(user));

        User result = userService.findUserById(111);

        assertEquals(result,user);

    }

    @Test
    public void testFindUserById_whenUserIdDoesNotExist_shouldThrowUserNotFoundException(){
        Mockito.when(userRepository.findById(111)).thenReturn(Optional.empty());
        assertThrows(UserNotFoundException.class,()-> userService.findUserById(111));

        Mockito.verify(userRepository).findById(111);

    }

    @Test
    public void testGetUserById_whenUserIdExist_shouldReturnUserDTO(){
        User user = new User(111,"name","surname",1, List.of(),List.of(),List.of(),List.of(),List.of());
        UserDTO userDTO = new UserDTO(user);
        Mockito.when(userRepository.findById(111)).thenReturn(Optional.of(user));

        UserDTO result = userService.getUserById(111);

        assertEquals(result,userDTO);
    }

    @Test
    public void testGetUserById_whenUserIdDoesNotExist_shouldThrowUserNotFoundException(){
        Mockito.when(userRepository.findById(111)).thenReturn(Optional.empty());
        assertThrows(UserNotFoundException.class,
                ()-> userService.getUserById(111));
    }


    @Test
    public void testUpdateUserById_whenUserIdExist_shouldReturnUserDTO(){
        int userId = 111;
        Email email = new Email();
        PhoneNumber phoneNumber = new PhoneNumber();
        Address address = new Address();
        UserUpdateDTO userUpdateDTO = new UserUpdateDTO(userId,"usename","password","name1","surname1","email",null,"phoneNumber",null,"address",null);
        User user = new User(111,"name","surname",1,List.of(),List.of(),List.of(),List.of(),List.of());
        User updatedUser = new User(111,"name1","surname1",1,List.of(email),List.of(phoneNumber),List.of(address),List.of(),List.of());
        User savedUser = new User(111,"name1","surname1",1,List.of(email),List.of(phoneNumber),List.of(address),List.of(),List.of());
        UserDTO userDTO = new UserDTO(savedUser);

        Mockito.when(userRepository.findById(userId)).thenReturn(Optional.of(user));
        Mockito.when(userRepository.save(updatedUser)).thenReturn(savedUser);

        UserDTO result = userService.updateUserById(userUpdateDTO);

        assertEquals(userDTO,result);

    }

}