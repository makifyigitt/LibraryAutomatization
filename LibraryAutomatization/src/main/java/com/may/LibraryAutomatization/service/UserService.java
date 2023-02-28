package com.may.LibraryAutomatization.service;


import com.may.LibraryAutomatization.core.exceptions.ErrorCode;
import com.may.LibraryAutomatization.core.exceptions.UserNotFoundException;
import com.may.LibraryAutomatization.dto.UserCreateDTO;
import com.may.LibraryAutomatization.dto.UserDTO;
import com.may.LibraryAutomatization.dto.UserUpdateDTO;
import com.may.LibraryAutomatization.model.user.Address;
import com.may.LibraryAutomatization.model.user.Email;
import com.may.LibraryAutomatization.model.user.PhoneNumber;
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
                .orElseThrow(() -> new UserNotFoundException(ErrorCode.USER_NOT_FOUND_EXCEPTION));
    }

    public UserDTO getUserById(int id) {
        return new UserDTO(findUserById(id));
    }


    public void createUser(UserCreateDTO userCreateDTO) {
        User newUser = new User();
        newUser.setUsername(userCreateDTO.getUserName());
        newUser.setPassword(userCreateDTO.getPassword());
        newUser.setName(userCreateDTO.getName());
        newUser.setSurname(userCreateDTO.getSurname());
        newUser.setStatus(userCreateDTO.getStatus());

        Email email = new Email(newUser,userCreateDTO.getEmailType(),userCreateDTO.getEmail());
        newUser.getEmails().add(email);

        PhoneNumber phoneNumber = new PhoneNumber(newUser,userCreateDTO.getPhoneNumberType(),userCreateDTO.getPhoneNumber());
        newUser.getPhoneNumbers().add(phoneNumber);

        Address address = new Address(newUser,userCreateDTO.getAddressType(),userCreateDTO.getAddress());
        newUser.getAddresses().add(address);
        userRepository.save(newUser);
    }

    public UserDTO updateUserById(UserUpdateDTO userUpdateDTO) {
        User inDB = findUserById(userUpdateDTO.getUserId());

        inDB.setUsername(userUpdateDTO.getUserName());
        inDB.setPassword(userUpdateDTO.getPassword());
        inDB.setName(userUpdateDTO.getName());
        inDB.setSurname(userUpdateDTO.getSurname());
        inDB.getEmails().add(new Email(inDB,userUpdateDTO.getEmailType(),userUpdateDTO.getEmail()));
        inDB.getAddresses().add(new Address(inDB,userUpdateDTO.getAddressType(),userUpdateDTO.getAddress()));
        inDB.getPhoneNumbers().add(new PhoneNumber(inDB,userUpdateDTO.getPhoneNumberType(),userUpdateDTO.getPhoneNumber()));

        userRepository.save(inDB);
        return new UserDTO(inDB);
    }


    public List<UserDTO> getAllActiveUsers() {
        List<User> activeUserList = userRepository.getAllActiveUsers();
        return activeUserList
                .stream()
                .map(UserDTO::new)
                .collect(Collectors.toList());
    }


    public void inactivateUser(int id) { //it is a soft delete.
        User inDB = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(ErrorCode.USER_NOT_FOUND_EXCEPTION));
        inDB.setStatus(0);
        userRepository.save(inDB);
    }

    public void toMakeActiveUser(int id) {
        User inDB= findUserById(id);
        inDB.setStatus(1);
        userRepository.save(inDB);
    }
}
