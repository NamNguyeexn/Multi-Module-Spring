package com.check.repositories;

import com.check.mapper.HumanMapper;
import com.check.models.Human;
import com.check.repositories.JPARepository.HumanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.Optional;
@Repository
public class CustomHumanRepository {
    @Autowired
    private HumanRepository humanRepository;
    public Optional<Human> getHumanById(int id) {
        return humanRepository.findOne(
                (root, query, criteriaBuilder)
                        -> criteriaBuilder.equal(root.get("id"), id)
        );
    }
    public Optional<Human> getHumanByPhone(String phone){
        return humanRepository.findOne(
                (root, query, criteriaBuilder)
                        -> criteriaBuilder.equal(root.get("phone"), phone)
        );
    }
    @Transactional
    public void saveHuman(Human human) {
        humanRepository.save(human);
    }
    public void deleteHumanById(int id){
        humanRepository.delete(
                (root, query, criteriaBuilder) ->
                    criteriaBuilder.equal(root.get("id"), id)
        );
    }
}
