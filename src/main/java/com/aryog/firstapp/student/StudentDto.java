package com.aryog.firstapp.student;

public record StudentDto(
        String firstname,
        String lastname,
        String email,
        Integer schoolId
) {
}
