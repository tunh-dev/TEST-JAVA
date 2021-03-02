package com.example.todotunh.controller;

import com.example.todotunh.exception.ResourceNotFoundException;
import com.example.todotunh.model.ToDo;
import com.example.todotunh.repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by tunh on 02/03/2021.
 */
@RestController
@RequestMapping("/api")
public class ToDoController {

    @Autowired
    ToDoRepository toDoRepository;

    @RequestMapping("/get-all-work")
    public List<ToDo> getAllWork() {
        return toDoRepository.findAll();
    }

    @RequestMapping("/create-new-work")
    public ToDo createNewWork(@Valid @RequestBody ToDo toDo) {
        return toDoRepository.save(toDo);
    }

    @RequestMapping("/get-work/{id}")
    public ToDo getWorkById(@PathVariable(value = "id") Long workId) {
        return toDoRepository.findById(workId)
                .orElseThrow(() -> new ResourceNotFoundException("Work", "id", workId));
    }

    @RequestMapping("/update-work/{id}")
    public ToDo updateWork(@PathVariable(value = "id") Long workId,
                           @Valid @RequestBody ToDo toDoDetails) {

        ToDo toDo = toDoRepository.findById(workId)
                .orElseThrow(() -> new ResourceNotFoundException("Work", "id", workId));

        ToDo updatedToDo = toDoRepository.save(toDo);
        return updatedToDo;
    }

    @DeleteMapping("/delete-work/{id}")
    public ResponseEntity<?> deleteWork(@PathVariable(value = "id") Long workId) {
        ToDo toDo = toDoRepository.findById(workId)
                .orElseThrow(() -> new ResourceNotFoundException("Work", "id", workId));

        toDoRepository.delete(toDo);

        return ResponseEntity.ok().build();
    }
}
