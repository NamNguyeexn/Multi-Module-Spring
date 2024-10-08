package com.check.repositories.JPARepository;

import com.check.models.Human;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface HumanRepository extends JpaRepository<Human, Integer>, JpaSpecificationExecutor<Human> {
    interface Specs{
        static Specification<Human> byId(int id){
            return (root, query, criteriaBuilder) ->
                    criteriaBuilder.equal(root.get("id"), id);
        }
        static Specification<Human> byPhone(String phone){
            return (root, query, criteriaBuilder) ->
                    criteriaBuilder.equal(root.get("phone"), phone);
        }
    }
}
