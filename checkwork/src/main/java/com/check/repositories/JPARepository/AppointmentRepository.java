package com.check.repositories.JPARepository;

import com.check.models.Appointment;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
@EnableJpaRepositories
public interface AppointmentRepository extends JpaRepository<Appointment, Integer>, JpaSpecificationExecutor<Appointment> {
    interface Specs{
        static Specification<Appointment> byHostId(int hostid){
            return (root, query, criteriaBuilder) ->
                    criteriaBuilder.equal(root.get("hostid"), hostid);
        }
        static Specification<Appointment> byId(int id){
            return (root, query, criteriaBuilder) ->
                    criteriaBuilder.equal(root.get("id"), id);
        }
        static Specification<Appointment> byRoom(String room){
            return (root, query, criteriaBuilder) ->
                    criteriaBuilder.equal(root.get("room"), room);
        }
        static Specification<Appointment> byStart(LocalDateTime start){
            return (root, query, criteriaBuilder) ->
                    criteriaBuilder.equal(root.get("start"), start);
        }
    }
}
