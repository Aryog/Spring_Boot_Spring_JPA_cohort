package com.aryog.firstapp.student;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

public record StudentDto(
        @NotEmpty(message = "First name is required!")
        String firstname,
        @NotEmpty(message = "Last name is required!")
        String lastname,
        @NotEmpty(message = "Email is required")
        @Email
        String email,
        Integer schoolId
) {
}
