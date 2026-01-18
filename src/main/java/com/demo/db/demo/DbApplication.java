package com.demo.db.demo;

import com.demo.db.demo.model.Task;
import com.demo.db.demo.repository.TaskJpaRepository;
import com.demo.db.demo.repository.TaskRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class DbApplication {

	public static void main(String[] args) {
		var context = SpringApplication.run(DbApplication.class, args);

		final var taskjpaRepository = context.getBean(TaskJpaRepository.class);

		var task1 = new Task();
		task1.setId("1");
		task1.setTitle("Task 1");
		task1.setDescription("Task 1 description");
		task1.setStatus("OPEN");
		taskjpaRepository.save(task1);

		var task2 = new Task();
		task2.setId("2");
		task2.setTitle("Task 2");
		task2.setDescription("Task 2 description");
		task2.setStatus("FINISHED");
		taskjpaRepository.save(task2);

		List<Task> tasks = taskjpaRepository.findAll();
		System.out.println("Print All Tasks");
		tasks.forEach(System.out::println);


		final var tasksByStatus = taskjpaRepository.findTaskByStatus("FINISHED");
		System.out.println("Print All Tasks by Status");
		tasksByStatus.forEach(System.out::println);

		System.out.println("Find by title");
		final var tasksByTitle = taskjpaRepository.findByTitle("Java Introuction");
		tasksByTitle.forEach(System.out::println);

		System.out.println("Find by title containing keyword");
		final var tasksByTitleKeyword = taskjpaRepository.findByTitleContaining("Loop");
		tasksByTitleKeyword.forEach(System.out::println);

	}

}
