package com.check.repositories.JPARepository;

import com.check.models.Schedule;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface ScheduleRepository extends JpaRepository<Schedule, Integer>, JpaSpecificationExecutor<Schedule> {
    interface Specs{
        static Specification<Schedule> byId(int id){
            return (root, query, criteriaBuilder) ->
                    criteriaBuilder.equal(root.get("id"), id);
        }
        static Specification<Schedule> byHostname(String hostname){
            return (root, query, criteriaBuilder) ->
                    criteriaBuilder.equal(root.get("hostname"), hostname);
        }
    }
}
