package com.example.todotunh.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ToDoRequestModel {

    @NotBlank
    @JsonProperty("work_name")
    private String workName;

    @NotBlank
    @JsonProperty("starting_date")
    private String startingDate;

    @NotBlank
    @JsonProperty("ending_date")
    private String endingDate;

    @NotNull
    @JsonProperty("status")
    private int status;
}
