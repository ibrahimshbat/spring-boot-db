package com.demo.db.demo.repository;

import com.demo.db.demo.model.Task;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


@Repository
public interface TaskJpaRepository extends JpaRepository<Task, String>{

    List<Task> findTaskByStatus(final String status);

    List<Task> findByTitle(final String title);

    List<Task> findByTitleContaining(final String keyword);

}
