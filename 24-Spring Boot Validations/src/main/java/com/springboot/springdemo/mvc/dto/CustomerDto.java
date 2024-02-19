package com.springboot.springdemo.mvc.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {

    public String firstName;

    @NotNull(message = "is required")
    @Size(min = 1, message = "is required")
    public String lastName;
}
