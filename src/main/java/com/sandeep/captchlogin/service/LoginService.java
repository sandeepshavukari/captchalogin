//
//import com.sandeep.captchlogin.repositary.Repo;
//import lombok.AllArgsConstructor;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsChecker;
//import org.springframework.stereotype.Service;
//
//@Service
//@AllArgsConstructor
//public class LoginService implements UserDetailsChecker {
//
//    private Repo repo;
//
//    @Override
//    public void check(UserDetails toCheck) {
//
//    }
//}
package com.sandeep.captchlogin.service;
import com.sandeep.captchlogin.model.MyAppUser;
import com.sandeep.captchlogin.repositary.MyAppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsChecker;
import org.springframework.stereotype.Service;

@Service
public class LoginService implements UserDetailsChecker {

    @Autowired
    private MyAppUserRepository repository;

    @Override
    public void check(UserDetails toCheck) {
        MyAppUser user = repository.findByUsername(toCheck.getUsername()).orElseThrow(() -> new DisabledException("User not found"));
        if (!user.isVerified()) {
            throw new DisabledException("Account is not verified");
        }
    }
}
