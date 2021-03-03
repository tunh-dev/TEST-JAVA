package com.example.todotunh.model;

import java.io.Serializable;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResponseModel<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    private T response;
    private String status;
    private String message;
}
