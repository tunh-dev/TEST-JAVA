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
public class UpdateToDoRequestModel {

    @NotNull
    @JsonProperty("id")
    private long id;

    @JsonProperty("work_name")
    private String workName;

    @JsonProperty("starting_date")
    private String startingDate;

    @JsonProperty("ending_date")
    private String endingDate;

    @JsonProperty("status")
    private int status;
}
