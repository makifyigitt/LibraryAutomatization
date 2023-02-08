//package com.may.LibraryAutomatization.auth;
//
//import com.may.LibraryAutomatization.model.user.User;
//import com.may.LibraryAutomatization.repository.UserRepository;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//@Service
//public class AuthUserService implements UserDetailsService {
//    private final UserRepository userRepository;
//
//    public AuthUserService(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        return userRepository.findByUsername(username)
//                .orElseThrow(()-> new UsernameNotFoundException(username));
//    }
//}
