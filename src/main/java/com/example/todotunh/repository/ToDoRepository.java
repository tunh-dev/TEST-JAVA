package com.example.todotunh.repository;

import com.example.todotunh.model.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by tunh on 02/03/2021.
 */

@Repository
public interface ToDoRepository extends JpaRepository<ToDo, Long> {

    ToDo findFirstById(long id);
}
