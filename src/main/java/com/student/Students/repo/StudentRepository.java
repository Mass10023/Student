package com.student.Students.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.student.Students.dto.StudentDetails;

@Repository
public interface StudentRepository extends MongoRepository<StudentDetails, String>{

	public StudentDetails findStudentByName(String name);
	public List<StudentDetails> findByAge(int age);
	public List<StudentDetails> findByClassNum(int classNum);
}
