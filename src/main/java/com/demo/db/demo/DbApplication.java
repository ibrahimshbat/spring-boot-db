package com.demo.db.demo;

import com.demo.db.demo.model.Task;
import com.demo.db.demo.repository.TaskRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class DbApplication {

	public static void main(String[] args) {
		var context = SpringApplication.run(DbApplication.class, args);

		final var taskRepository = context.getBean(TaskRepository.class);

		var task1 = new Task();
		task1.setId("1");
		task1.setTitle("Task 1");
		task1.setDescription("Task 1 description");
		task1.setStatus("OPEN");

		taskRepository.save(task1);
		List<Task> tasks = taskRepository.findAll();
		System.out.println("Tasks: " + tasks);

	}

}
