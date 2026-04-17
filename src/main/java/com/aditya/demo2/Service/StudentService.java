package com.aditya.demo2.Service;

import com.aditya.demo2.Entity.Student;
import com.aditya.demo2.Repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepo repo;

    // ➤ Add Student
    public Student addStudent(Student student) {
        return repo.save(student);
    }

    // ➤ Get All Students
    public List<Student> getAllStudents() {
        return repo.findAll();
    }

    // ➤ Get Student by ID
    public Student getStudentById(int id) {
        return repo.findById(id).orElse(null);
    }

    // ➤ Delete Student
    public String deleteStudent(int id) {
        repo.deleteById(id);
        return "Student deleted";
    }
    public String deleteAll(){
         repo.deleteAll();
         return "All Student  deleted";
    }
}