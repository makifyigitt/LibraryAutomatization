package com.may.LibraryAutomatization.repository;

import com.may.LibraryAutomatization.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

    @Query("Select c From User c where c.status = 1")
    List<User> getAllActiveUsers();
}
