package com.check.repositories.JPARepository;

import com.check.mediator.models.GroupChat;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface GroupChatRepository extends JpaRepository<GroupChat, Integer>, JpaSpecificationExecutor<GroupChat> {
    interface Specs{
        static Specification<GroupChat> byEmail(String email){
            return (root, query, criteriaBuilder) ->
                    criteriaBuilder.like(root.get("emails"), email);
        }
    }
}
