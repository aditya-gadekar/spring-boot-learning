package com.aditya.demo2.Controller;

import com.aditya.demo2.Entity.Student;
import com.aditya.demo2.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService service;

    // ➤ Add Student
    @PostMapping("/add")
    public Student addStudent(@RequestBody Student student) {
        return service.addStudent(student);
    }

    // ➤ Get All Students
    @GetMapping("/all")
    public List<Student> getAllStudents() {
        return service.getAllStudents();
    }

    // ➤ Get Student by ID
    @GetMapping("/{id}")
    public Student getStudent(@PathVariable int id) {
        return service.getStudentById(id);
    }

    // ➤ Delete Student
    @DeleteMapping("/delete/{id}")
    public String deleteStudent(@PathVariable int id) {
        return service.deleteStudent(id);
    }
    @DeleteMapping("/deleteAll")
    public String deleteAll(){
        return service.deleteAll();

    }
}