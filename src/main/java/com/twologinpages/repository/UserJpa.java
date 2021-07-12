package com.twologinpages.repository;

import com.twologinpages.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJpa extends JpaRepository<User, Long> {

    User findUserByEmail (String email);


}
