package com.example.todotunh.controller;

import com.example.todotunh.model.ResponseModel;
import com.example.todotunh.model.request.GetListPagingRequestModel;
import com.example.todotunh.model.request.ToDoRequestModel;
import com.example.todotunh.model.request.UpdateToDoRequestModel;
import com.example.todotunh.model.response.ListToDoResponseModel;
import com.example.todotunh.repository.ToDoRepository;
import com.example.todotunh.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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

    private static final String ERROR_STATUS = "ERROR";

    @RequestMapping("/get-all-work")
    public ResponseModel<ListToDoResponseModel> getAllWork(@Valid @RequestBody GetListPagingRequestModel requestModel) {

        ResponseModel<ListToDoResponseModel> responseModel = new ResponseModel<>();

        try {
            responseModel = toDoService.getAllWork(requestModel);
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
            responseModel = toDoService.creatNewWork(requestModel);
        } catch (Exception e) {
            responseModel.setStatus(ERROR_STATUS);
            responseModel.setMessage(e.getMessage());
        }

        return responseModel;
    }

    @RequestMapping("/update-work")
    public ResponseModel<?> updateWork(@Valid @RequestBody UpdateToDoRequestModel requestModel) {

        ResponseModel<?> responseModel = new ResponseModel<>();
        try {
            responseModel = toDoService.updateToDoWork(requestModel);
        } catch (Exception e) {
            responseModel.setStatus(ERROR_STATUS);
            responseModel.setMessage(e.getMessage());
        }

        return responseModel;
    }

    @DeleteMapping("/delete-work/{id}")
    public ResponseModel<?> deleteWork(@PathVariable(value = "id") Long workId) {

        ResponseModel<?> responseModel = new ResponseModel<>();
        try {
            responseModel = toDoService.deleteToDoWork(workId);
        } catch (Exception e) {
            responseModel.setStatus(ERROR_STATUS);
            responseModel.setMessage(e.getMessage());
        }

        return responseModel;
    }
}
