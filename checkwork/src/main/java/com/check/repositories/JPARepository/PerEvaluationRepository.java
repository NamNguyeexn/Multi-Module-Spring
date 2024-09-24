package com.check.repositories.JPARepository;

import com.check.models.PerEvaluation;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface PerEvaluationRepository extends JpaRepository<PerEvaluation, Integer>,
        JpaSpecificationExecutor<PerEvaluation> {
    interface Specs{
        static Specification<PerEvaluation> byUserStateId(int userStateId){
            return (root, query, criteriaBuilder) ->
                    criteriaBuilder.equal(root.get("userstateid"), userStateId);
        }
        static Specification<PerEvaluation> byWorkHourId(int workHourId){
            return (root, query, criteriaBuilder) ->
                    criteriaBuilder.equal(root.get("workHourid"), workHourId);
        }
    }
}
