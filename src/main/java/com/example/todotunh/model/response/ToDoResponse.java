package com.example.todotunh.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ToDoResponse {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("work_name")
    private String workName;

    @JsonProperty("starting_date")
    private String startingDate;

    @JsonProperty("ending_date")
    private String endingDate;

    @JsonProperty("status")
    private String status;
}
