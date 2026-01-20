package com.demo.db.demo.repository;

import com.demo.db.demo.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TaskRepository{

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public TaskRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(Task task) {
        System.out.println("Saved");
        final var sql = "INSERT INTO task (id, title, description, status) VALUES (?, ?, ?, ?)";
        final var effectRows = jdbcTemplate.update(sql, task.getId(), task.getTitle(), task.getDescription(), task.getStatus());

        System.out.println("Effect rows: " + effectRows);
    }

    public List<Task> findAll() {
        System.out.println("Find all");
        final var sql = "SELECT * FROM task";

        RowMapper<Task> mapper = (rs, raw) ->
        {
            Task task = new Task();
            task.setId(rs.getString("id"));
            task.setTitle(rs.getString("title"));
            task.setDescription(rs.getString("description"));
            task.setStatus(rs.getString("status"));
            return task;
        };

        var tasks = jdbcTemplate.query(sql, mapper);
        return tasks;
    }
}
