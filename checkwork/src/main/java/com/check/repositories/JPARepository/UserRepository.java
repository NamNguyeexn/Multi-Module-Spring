package com.check.repositories.JPARepository;

import com.check.models.User;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface UserRepository extends JpaRepository<User, Integer>, JpaSpecificationExecutor<User> {
    interface Specs{
        static Specification<User> byId(int id){
            return (root, query, criteriaBuilder) ->
                    criteriaBuilder.equal(root.get("id"), id);
        }
        static Specification<User> byUsername(String username){
            return (root, query, criteriaBuilder) ->
                    criteriaBuilder.equal(root.get("username"), username);
        }
        static Specification<User> byEmail(String email){
            return (root, query, criteriaBuilder) ->
                    criteriaBuilder.equal(root.get("email"), email);
        }
        static Specification<User> byDepartment(String department){
            return (root, query, criteriaBuilder) ->
                    criteriaBuilder.equal(root.get("department"), department);
        }
        static Specification<User> byEmployeeCode(String employeeCode){
            return (root, query, criteriaBuilder) ->
                    criteriaBuilder.equal(root.get("employeeCode"), employeeCode);
        }

    }
}
