package com.check.repositories.JPARepository;

import com.check.models.Room;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface RoomRepository extends JpaRepository<Room, Integer>, JpaSpecificationExecutor<Room> {
    interface Specs{
        static Specification<Room> byId(int id){
            return (root, query, criteriaBuilder) ->
                    criteriaBuilder.equal(root.get("id"), id);
        }
        static Specification<Room> byName(String name){
            return (root, query, criteriaBuilder) ->
                    criteriaBuilder.equal(root.get("name"), name);
        }
    }
}
