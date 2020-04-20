package com.example.facebook.facebookApplication.repository;

import com.example.facebook.facebookApplication.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository <User,Integer> {

    @Query(value = "SELECT u from User u where u.emailId=:emailId")
    public List<User> getByEmailId(@Param("emailId") String emailId);

}
