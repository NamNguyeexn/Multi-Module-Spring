package com.check.repositories.JPARepository;

import com.check.models.UserState;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UserStateRepository extends JpaRepository<UserState, Integer>, JpaSpecificationExecutor<UserState> {
    interface Specs {
        static Specification<UserState> byState(String state) {
            return (root, query, cb) -> cb.equal(root.get("state"), state);
        }
        static Specification<UserState> byUserId(String userId) {
            return (root, query, cb) -> cb.equal(root.get("userId"), userId);
        }
    }
}
