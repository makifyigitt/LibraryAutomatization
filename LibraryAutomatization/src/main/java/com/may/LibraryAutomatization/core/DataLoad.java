//package com.may.LibraryAutomatization.core;
//
//
//import com.may.LibraryAutomatization.model.user.User;
//import com.may.LibraryAutomatization.model.user.UserRole;
//import com.may.LibraryAutomatization.repository.RoleRepository;
//import com.may.LibraryAutomatization.repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.ApplicationArguments;
//import org.springframework.boot.ApplicationRunner;
//import org.springframework.stereotype.Component;
//
//import java.util.ArrayList;
//import java.util.List;
//
//    @Component
//    public class DataLoad implements ApplicationRunner {
//
//
//        @Autowired
//        private UserRepository userRepository;
//
//        @Autowired
//        private RoleRepository roleRepository;
//
//        @Override
//        public void run(ApplicationArguments args) throws Exception {
//            //Admin save
//
//            UserRole roleAdmin=UserRole.builder().id(1).roleName("ROLE_ADMIN").build();
//            UserRole roleUser=UserRole.builder().id(2).roleName("ROLE_USER").build();
//
//            roleRepository.save(roleAdmin);
//            roleRepository.save(roleUser);
//
//
//            List<UserRole> adminRoleList=new ArrayList<>();
//            adminRoleList.add(roleAdmin);
//
//            User admin= new User("admin","12345",adminRoleList,"admin","admin");
//            userRepository.save(admin);
//
//            //User save
//
//            List<UserRole> userRoleList=new ArrayList<>();
//            userRoleList.add(roleUser);
//
//            User user=new User("user","12345",adminRoleList,"user","user");
//            userRepository.save(user);
//
//            System.out.println("-- Roles --");
//            roleRepository.findAll().forEach(System.out::println);
//            System.out.println("-- User --");
//            userRepository.findAll().forEach(System.out::println);
//
//        }
//    }
//
