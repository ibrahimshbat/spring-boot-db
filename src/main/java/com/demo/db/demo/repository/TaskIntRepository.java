package com.demo.db.demo.repository;

import com.demo.db.demo.model.Task;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskIntRepository extends CrudRepository<Task, String> {
    List<Task> findByStatus(String id);
}
