package com.check.repositories.JPARepository;

import com.check.models.WorkHour;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface WorkHourRepository extends JpaRepository<WorkHour, Integer>, JpaSpecificationExecutor<WorkHour> {
    interface Specs{
        static Specification<WorkHour> byId(int id){
            return (root, query, criteriaBuilder) ->
                    criteriaBuilder.equal(root.get("id"), id);
        }
        static Specification<WorkHour> byUserId(int userid){
            return (root, query, criteriaBuilder) ->
                    criteriaBuilder.equal(root.get("userid"), userid);
        }
        static Specification<WorkHour> byNote(String note){
            return (root, query, criteriaBuilder) ->
                    criteriaBuilder.equal(root.get("note"), note);
        }
    }
}
