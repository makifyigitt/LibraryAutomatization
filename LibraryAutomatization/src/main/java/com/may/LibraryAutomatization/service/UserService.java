package com.may.LibraryAutomatization.service;

import com.may.LibraryAutomatization.core.exceptions.ErrorCode;
import com.may.LibraryAutomatization.core.exceptions.UserNotFoundException;
import com.may.LibraryAutomatization.dto.UserCreateDTO;
import com.may.LibraryAutomatization.dto.UserDTO;
import com.may.LibraryAutomatization.dto.UserUpdateDTO;
import com.may.LibraryAutomatization.model.user.User;
import com.may.LibraryAutomatization.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }



    public List<UserDTO> getAllUsers() { //Get all active and passive users.
        List<User> userList = userRepository.findAll();
        return userList.stream().map(UserDTO::new).collect(Collectors.toList());
    }

    protected User findUserById(int id){
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(ErrorCode.USER_NOT_FOUN_EXCEPTATION));
    }

    public UserDTO getUserById(int id) {
        return new UserDTO(findUserById(id));
    }


    public void updateUserById(int id, UserUpdateDTO userUpdateDTO) {
        User inDB = userRepository.findById(id)
                .orElseThrow(()->new UserNotFoundException(ErrorCode.USER_NOT_FOUN_EXCEPTATION));
        inDB.setName(userUpdateDTO.getName());
        inDB.setSurname(userUpdateDTO.getSurname());
        inDB.getEmails().add(userUpdateDTO.getEmail());
        inDB.getAddresses().add(userUpdateDTO.getAddress());
        inDB.getPhoneNumbers().add(userUpdateDTO.getPhoneNumber());
        userRepository.save(inDB);
    }


    public List<UserDTO> getAllActiveUsers() {
        List<User> activeUserList = userRepository.getAllActiveUsers();
        return activeUserList.stream().map(UserDTO::new).collect(Collectors.toList());
    }


    public void deleteUser(int id) { //it is a soft delete.
        User inDB = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(ErrorCode.USER_NOT_FOUN_EXCEPTATION));
        inDB.setStatus(0);
        userRepository.save(inDB);
    }


    public void createUser(UserCreateDTO userCreateDTO) {
        User newUser = new User();
        newUser.setName(userCreateDTO.getName());
        newUser.setSurname(userCreateDTO.getSurname());
        newUser.setStatus(userCreateDTO.getStatus());
        newUser.getEmails().add(userCreateDTO.getEmail());
        newUser.getAddresses().add(userCreateDTO.getAddress());
        newUser.getPhoneNumbers().add(userCreateDTO.getPhoneNumber());
        userRepository.save(newUser);
    }


    public void toMakeActiveUser(int id) {
        User inDB= findUserById(id);
        inDB.setStatus(1);
        userRepository.save(inDB);
    }
}
