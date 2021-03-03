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
public class GetListPagingRequestModel {

    @NotNull
    @JsonProperty("page")
    private int page;

    @NotNull
    @JsonProperty("size")
    private int size;

    @NotBlank
    @JsonProperty("field_sort")
    private String fieldSort;
}
