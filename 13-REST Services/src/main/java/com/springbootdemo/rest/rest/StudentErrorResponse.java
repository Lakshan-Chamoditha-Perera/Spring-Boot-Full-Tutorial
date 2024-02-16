package com.springbootdemo.rest.rest;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class StudentErrorResponse {
    private Integer status;
    private String message;
    private Long timeStamp;
}
