package com.springboot.springdemo.mvc.dto;

import com.springboot.springdemo.mvc.validation.CourseCode;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {

    public String firstName;

    @NotNull(message = "Last name is required")
    @Size(min = 1, message = "is required")
    public String lastName;

    @NotNull(message = "Free-pass is required")
    @Min(value = 0, message = "Free-pass must be grater than or equal to zero")
    @Max(value = 10, message = "Free-pass must be less than or equal to 10")
    private Integer freePasses;

    @Pattern(regexp = "^[a-zA-Z0-9]{5}", message = "Postal code can contain only 5 chars/digits")
    private String postalCode;

    @CourseCode(value = "TOP", message = "must start with TOP")
    private String courseCode;

}
