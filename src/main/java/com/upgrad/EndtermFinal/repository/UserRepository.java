package com.upgrad.EndtermFinal.repository;

import com.upgrad.EndtermFinal.model.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

    public interface UserRepository extends JpaRepository<UserDetails,Integer> {

    //public UserDetails findUserDetailsByName(String name);

    @Query("SELECT u FROM UserDetails u WHERE u.name LIKE %?1%")
    public List<UserDetails> findAllByName(String keyword);
}
