package com.may.LibraryAutomatization.repository;


import com.may.LibraryAutomatization.model.blacklist.BlackList;
import com.may.LibraryAutomatization.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface BlackListRepository extends JpaRepository<BlackList,Integer> {
    @Query("select c from BlackList c where c.user = :user ")
    Optional<List<BlackList>> findAllBlackListsByUser(@Param("user") User user);
}
