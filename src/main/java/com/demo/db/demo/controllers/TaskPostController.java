package com.demo.db.demo.controllers;

import com.demo.db.demo.model.Task;
import com.demo.db.demo.repository.TaskJpaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/tasks")
public class TaskPostController {

    private static final Logger logger = LoggerFactory.getLogger(TaskPostController.class);
    private final TaskJpaRepository taskJpaRepository;

    @Autowired
    public TaskPostController(final TaskJpaRepository taskJpaRepository) {
        this.taskJpaRepository = taskJpaRepository;
    }

    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
        taskJpaRepository.save(task);
        logger.info("Task created: {}", task);

        return new ResponseEntity<>(task, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Task>> getTasks() {
        final var tasks = taskJpaRepository.findAll();

        logger.info("Tasks found: {}", tasks);

        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }
}
