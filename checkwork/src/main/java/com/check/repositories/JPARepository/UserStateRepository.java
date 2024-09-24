package com.check.repositories.JPARepository;

import com.check.models.ENUM.State;
import com.check.models.UserState;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UserStateRepository extends JpaRepository<UserState, Integer>, JpaSpecificationExecutor<UserState> {
    interface Specs {
        static Specification<UserState> byState(State state) {
            return (root, query, cb) -> cb.equal(root.get("state"), state);
        }
        static Specification<UserState> byUserId(int userId) {
            return (root, query, cb) -> cb.equal(root.get("userid"), userId);
        }
    }
}
