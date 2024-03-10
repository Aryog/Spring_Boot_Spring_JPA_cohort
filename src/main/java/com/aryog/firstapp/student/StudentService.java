package com.aryog.firstapp.student;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {
    private final StudentRepository repository;
    private final StudentMapper studentMapper;

    public StudentService(StudentRepository repository, StudentMapper studentMapper) {
        this.repository = repository;
        this.studentMapper = studentMapper;
    }

    public StudentResponseDto saveStudent(StudentDto dto){
        var student = studentMapper.toStudent(dto);
        var savedStudent = repository.save(student);
        return studentMapper.toStudentResponseDto(savedStudent);
    }
    public List<StudentResponseDto> findAllStudent(){
        var savedStudent = repository.findAll();
        return savedStudent.stream().map(studentMapper::toStudentResponseDto).collect(Collectors.toList());
    }

    public StudentResponseDto findStudentById(Integer id){
        var savedStudent = repository.findById(id).orElse(new Student());
        return studentMapper.toStudentResponseDto(savedStudent);
    }
    public List<StudentResponseDto> findStudentsByName(
            String name
    ){
        var savedStudent = repository.findAllByFirstnameContaining(name);
        return savedStudent.stream().map(studentMapper::toStudentResponseDto).collect(Collectors.toList());
    }

    public void deleteStudent(Integer id){
        repository.deleteById(id);
    }
}
