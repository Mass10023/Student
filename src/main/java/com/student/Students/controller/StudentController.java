package com.student.Students.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student.Students.dto.StudentDetails;
import com.student.Students.repo.StudentRepository;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;
    
 // Retrieves a list of students by their age.
    @GetMapping("/getByAge/{age}")
    public List<StudentDetails> getStudentsByAge(@PathVariable int age) {
        List<StudentDetails> students = studentRepository.findByAge(age);
        return students;
    }

 // Retrieves a list of students by their class number.
    @GetMapping("/getByClassNum/{classNum}")
    public List<StudentDetails> getStudentsByClassNum(@PathVariable int classNum) {
        List<StudentDetails> students = studentRepository.findByClassNum(classNum);
        return students;
    }

 // Adds a new student to the database.
    @PostMapping("/add")
    public String addStudent(@RequestBody StudentDetails student) {
        studentRepository.save(student);
        return "Student added successfully!";
    }
    
 // Updates the details of a student identified by their name.
    @PostMapping("/update/{name}")
    public String updateStudent(@PathVariable String name, @RequestBody StudentDetails updatedStudent) {
        StudentDetails existingStudent = studentRepository.findStudentByName(name);
        if (existingStudent != null) {
            // Update the details
            existingStudent.setAge(updatedStudent.getAge());
            existingStudent.setClassNum(updatedStudent.getClassNum());
            studentRepository.save(existingStudent);
            return "Student updated successfully!";
        } else {
            return "Student not found!";
        }
    }

 // Retrieves details of a student by their name.
    @GetMapping("/get/{name}")
    public StudentDetails getStudent(@PathVariable String name) {
        StudentDetails student = studentRepository.findStudentByName(name);        
        return student;
    	
//    	return studentRepository.findAll();
    }
    
 // Deletes a student identified by their name.
@PostMapping("/delete/{name}")
public String deleteStudent(@PathVariable String name) {
    StudentDetails student = studentRepository.findStudentByName(name);
    if (student != null) {
        studentRepository.delete(student);
        return "Student deleted successfully!";
    } else {
        return "Student not found!";
    }
    
}
}