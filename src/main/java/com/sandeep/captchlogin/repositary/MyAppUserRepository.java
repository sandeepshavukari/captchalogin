package com.sandeep.captchlogin.repositary;

import java.util.Optional;

import com.sandeep.captchlogin.model.MyAppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyAppUserRepository extends JpaRepository<MyAppUser, Long>{

    Optional<MyAppUser> findByUsername(String username);

    MyAppUser findByEmail(String email);

}