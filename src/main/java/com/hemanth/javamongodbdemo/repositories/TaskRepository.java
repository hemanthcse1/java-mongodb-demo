package com.hemanth.javamongodbdemo.repositories;

import com.hemanth.javamongodbdemo.model.Task;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends MongoRepository<Task,String> {
    List<Task> findByPriority(int priority);

    @Query("{assignee: ?0 }")
    List<Task> getTaskByAssignee(String assignee);
}
