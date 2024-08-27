package com.check.repositories;

import com.check.models.Room;
import com.check.repositories.JPARepository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Component
//@EnableJpaRepositories(basePackages = {"com.check.repositories.JPARepository.RoomRepository"})
public class CustomRoomRepository {
    @Autowired
    private RoomRepository roomRepository;
    public Optional<List<Room>> getRooms(){
        return Optional.of(roomRepository.findAll());
    }
    public Optional<Room> getRoomById(int id){
        return roomRepository.findOne(
                (root, query, criteriaBuilder)
                        -> criteriaBuilder.equal(root.get("id"), id)
        );
    }
    public Optional<Room> getRoomByName(String name){
        return roomRepository.findOne(
                (root, query, criteriaBuilder)
                        -> criteriaBuilder.equal(root.get("name"), name)
        );
    }
    public void save(Room room){
        roomRepository.save(room);
    }
}
