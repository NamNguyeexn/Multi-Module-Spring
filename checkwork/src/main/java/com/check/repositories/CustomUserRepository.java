package com.check.repositories;

import com.check.models.User;
import com.check.repositories.JPARepository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
@Component
//@Primary
//@EnableJpaRepositories(basePackages = {"com.check.repositories.JPARepository.UserRepository"})
public class CustomUserRepository {
    @Autowired
    private UserRepository userRepository;

    public Optional<User> getUserByUsername(String username){
        return userRepository.findOne(
            (root, query, criteriaBuilder)
                    -> criteriaBuilder.equal(root.get("username"), username)
        );
    }
    @Transactional
    public void saveUser(User user){
        userRepository.save(user);
    }
    public Optional<List<User>> getUsersByDepartment(String department){
        return Optional.of(userRepository.findAll(
                (root, query, criteriaBuilder)
                        -> criteriaBuilder.equal(root.get("department"), Optional.of(department.toUpperCase()))
        ));
    }
    public Optional<User> getUserByEmail(String email){
        return userRepository.findOne(
                (root, query, criteriaBuilder)
                        -> criteriaBuilder.equal(root.get("email"), email)
        );
    }
}
