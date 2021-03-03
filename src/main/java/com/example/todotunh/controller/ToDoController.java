package com.example.todotunh.controller;

import com.example.todotunh.exception.ResourceNotFoundException;
import com.example.todotunh.model.ResponseModel;
import com.example.todotunh.model.ToDo;
import com.example.todotunh.model.request.ToDoRequestModel;
import com.example.todotunh.model.response.ListToDoResponseModel;
import com.example.todotunh.repository.ToDoRepository;
import com.example.todotunh.service.ToDoService;
import lombok.AllArgsConstructor;
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

    @Autowired
    ToDoService toDoService;

    private static final String SUCCESS_STATUS = "SUCCESS";
    private static final String ERROR_STATUS = "ERROR";

    @RequestMapping("/get-all-work")
    public ResponseModel<ListToDoResponseModel> getAllWork() {

        ResponseModel<ListToDoResponseModel> responseModel = new ResponseModel<>();

        try {
            // processing data to return FE
            responseModel = toDoService.getAllWork();

        } catch (Exception e) {
            responseModel.setStatus(ERROR_STATUS);
            responseModel.setMessage(e.getMessage());
        }

        return responseModel;
    }

    @RequestMapping("/create-new-work")
    public ResponseModel<?> createNewWork(@Valid @RequestBody ToDoRequestModel requestModel) {

        ResponseModel<?> responseModel = new ResponseModel<>();
        try {
            // processing data to return FE
            responseModel = toDoService.creatNewWork(requestModel);

        } catch (Exception e) {
            responseModel.setStatus(ERROR_STATUS);
            responseModel.setMessage(e.getMessage());
        }

        return responseModel;
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
