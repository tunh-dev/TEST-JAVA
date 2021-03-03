package com.example.todotunh.service;

import com.example.todotunh.model.ResponseModel;
import com.example.todotunh.model.request.GetListPagingRequestModel;
import com.example.todotunh.model.request.ToDoRequestModel;
import com.example.todotunh.model.request.UpdateToDoRequestModel;
import com.example.todotunh.model.response.ListToDoResponseModel;

public interface ToDoService {

    ResponseModel<ListToDoResponseModel> getAllWork(GetListPagingRequestModel requestModel);

    ResponseModel<?> creatNewWork(ToDoRequestModel requestModel);

    ResponseModel<?> updateToDoWork(UpdateToDoRequestModel requestModel);

    ResponseModel<?> deleteToDoWork(Long id);
}
