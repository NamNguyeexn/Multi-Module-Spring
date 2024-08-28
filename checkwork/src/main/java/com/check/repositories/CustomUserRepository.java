package com.check.repositories;

import com.check.models.User;
import com.check.repositories.JPARepository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static com.check.repositories.JPARepository.UserRepository.Specs.*;

@Repository
//@Primary
//@EnableJpaRepositories(basePackages = {"com.check.repositories.JPARepository.UserRepository"})
public class CustomUserRepository {
    @Autowired
    private UserRepository userRepository;

    public Optional<User> getUserByUsername(String username){
        return userRepository.findOne(byUsername(username));
    }
    @Transactional
    public void saveUser(User user){
        userRepository.save(user);
    }
    public Optional<List<User>> getUsersByDepartment(String department){
        return Optional.of(userRepository.findAll(byDepartment(department)));
    }
    public Optional<User> getUserByEmail(String email){
        return userRepository.findOne(byEmail(email));
    }
}
