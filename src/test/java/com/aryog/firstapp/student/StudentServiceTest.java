package com.aryog.firstapp.student;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class StudentServiceTest {
    // Which service we want to test

    @InjectMocks
    private StudentService studentService;

    @Mock
    private StudentRepository repository;
    @Mock
    private StudentMapper studentMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    @Test
    public void should_successfully_save_a_student(){
        // Given
        StudentDto dto = new StudentDto(
                "John",
                "Doe",
                "john@gmail.com",
                1
        );
        Student student = new Student("John","Doe","john@gmail.com",20);
        Student savedStudent = new Student("John","Doe","john@gmail.com",20);
        savedStudent.setId(1);

        // Mock calls
        when(studentMapper.toStudent(dto)).thenReturn(student);
        when(repository.save(student)).thenReturn(savedStudent);
        when(studentMapper.toStudentResponseDto(savedStudent))
                .thenReturn(new StudentResponseDto(
                        "John",
                        "Doe",
                        "john@gmail.com"));
        // When
        StudentResponseDto responseDto = studentService.saveStudent(dto);


        // Then
        assertEquals(dto.firstname(),responseDto.firstname());
        assertEquals(dto.lastname(),responseDto.lastname());
        assertEquals(dto.email(),responseDto.email());
        verify(studentMapper, times(1))
                .toStudent(dto);
        verify(repository, times(1))
                .save(student);
        verify(studentMapper, times(1))
                .toStudentResponseDto(savedStudent);

    }

    @Test
    public void should_return_all_students(){
        // Given
        List<Student> students = new ArrayList<>();
        students.add(new Student("John","Doe","john@gmail.com",20));

        // Mock the calls
        when(repository.findAll()).thenReturn(students);
        when(studentMapper.toStudentResponseDto(any(Student.class)))
                .thenReturn(new StudentResponseDto(
                "John",
                "Doe",
                "john@gmail.com"
        ));

        List<StudentResponseDto> responseDtos = studentService.findAllStudent();

        // Then
        assertEquals(students.size(),responseDtos.size());
        verify(repository,times(1)).findAll();
    }


    @Test
    public void should_return_student_by_id(){
        Student student = new Student("John","Doe","john@gmail.com",20);
        Integer student_id  = 1;
        // Mock the calls
        when(repository.findById(student_id)).thenReturn(Optional.of(student));
        when(studentMapper.toStudentResponseDto(any(Student.class))).thenReturn(new StudentResponseDto("John","Doe","john@gmail.com"));

        StudentResponseDto responseDto = studentService.findStudentById(student_id);
        // Then
        assertEquals(student.getFirstname(),responseDto.firstname());
        assertEquals(student.getLastname(),responseDto.lastname());
        assertEquals(student.getEmail(),responseDto.email());

        verify(repository,times(1)).findById(student_id);
    }

    @Test
    public void should_find_student_by_name(){
        // Given
        String studentName= "John";
        List<Student> students = new ArrayList<>();
        students.add(new Student("John","Doe","john@gmail.com",20));

        // Mock the calls
        when(repository.findAllByFirstnameContaining(studentName)).thenReturn(students);
        when(studentMapper.toStudentResponseDto(any(Student.class)))
                .thenReturn(new StudentResponseDto(
                        "John",
                        "Doe",
                        "john@gmail.com"
                ));

        var responseDto = studentService.findStudentsByName((studentName));

        // Then
        assertEquals(students.size(),responseDto.size());
        verify(repository,times(1))
                .findAllByFirstnameContaining(studentName);

    }
}
