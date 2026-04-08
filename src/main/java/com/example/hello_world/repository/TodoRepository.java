package com.example.hello_world.repository;

import com.example.hello_world.model.Todo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TodoRepository extends MongoRepository<Todo, String> {

    List<Todo> findByCompleted(boolean completed);
}
