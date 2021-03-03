package com.example.todotunh.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListToDoResponseModel {

    @JsonProperty("list_todo_work")
    private List<ToDoResponse> listTodoWork;
}
