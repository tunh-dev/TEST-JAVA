package com.example.todotunh.service;

import com.example.todotunh.model.ResponseModel;
import com.example.todotunh.model.request.ToDoRequestModel;
import com.example.todotunh.model.response.ListToDoResponseModel;

public interface ToDoService {

    ResponseModel<ListToDoResponseModel> getAllWork();

    ResponseModel<?> creatNewWork(ToDoRequestModel requestModel);
}
