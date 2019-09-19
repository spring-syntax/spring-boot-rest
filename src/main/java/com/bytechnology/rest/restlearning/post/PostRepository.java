package com.bytechnology.rest.restlearning.post;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post,Integer> {

    @Query("SELECT post FROM Post post LEFT JOIN User user ON post.user.id=user.id WHERE post.user.id=:user_id")
    List<Post> findAllNotes(@Param("user_id") int user_id);
}
