package com.poly.ps36680_lab3.model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student2 {
    @NotBlank
    @Email
    String email;

    @NotBlank
    String fullname;

    @NotNull
    @PositiveOrZero
    @Max(10)
    Double marks;

    @NotNull
    Boolean gender;

    @NotBlank
    String country;
}