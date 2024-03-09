package com.aryog.firstapp;

public record StudentDto(
        String firstname,
        String lastname,
        String email,
        Integer schoolId
) {
}
