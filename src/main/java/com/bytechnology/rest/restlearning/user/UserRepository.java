package com.bytechnology.rest.restlearning.user;

import com.bytechnology.rest.restlearning.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
