package com.may.LibraryAutomatization.dto;


import com.may.LibraryAutomatization.model.user.User;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class UserDTO {
    private int id;
    private String name;
    private String surname;
    private int status;

    private List<EmailDTO> emailDTO;
    private List<AddressDTO> addressList;
    private List<PhoneNumberDTO> phoneNumberList;


    public UserDTO(User user){
        this.id = user.getId();
        this.name = user.getName();
        this.surname = user.getSurname();
        this.status = user.getStatus();
        this.emailDTO = user.getEmails()
                .stream()
                .map(EmailDTO::new)
                .collect(Collectors.toList());
        this.addressList = user.getAddresses()
                .stream()
                .map(AddressDTO::new)
                .collect(Collectors.toList());
        this.phoneNumberList = user.getPhoneNumbers()
                .stream()
                .map(PhoneNumberDTO::new)
                .collect(Collectors.toList());
    }
}
