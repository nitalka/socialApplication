package com.example.facebook.facebookApplication.repository;

import com.example.facebook.facebookApplication.models.Post;
import com.example.facebook.facebookApplication.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.UUID;

public interface PostRepository extends JpaRepository<Post,Integer> {

    @Query(value = "SELECT p from Post p where p.postId=:postId")
    public List<Post> getByPostId(@Param("postId") String postId);

}
