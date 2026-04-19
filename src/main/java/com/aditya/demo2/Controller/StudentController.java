package com.aditya.demo2.Controller;

import com.aditya.demo2.Entity.Student;
import com.aditya.demo2.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService service;

    // ➤ Add Student
    @PostMapping("/add")
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
        Student savedStudent = service.addStudent(student);

        return ResponseEntity
                .created(URI.create("/student/" + savedStudent.getId()))
                .body(savedStudent);
    }

    // ➤ Get All Students
    @GetMapping("/all")
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> students = service.getAllStudents();

        if (students.isEmpty()) {
            return ResponseEntity.noContent().build(); // 204
        }

        return ResponseEntity.ok(students); // 200
    }

    // ➤ Get Student by ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getStudent(@PathVariable int id) {
        Student student = service.getStudentById(id);

        if (student == null) {
            return ResponseEntity.status(404).body("Student not found");
        }

        return ResponseEntity.ok(student);
    }

    // ➤ Delete Student by ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable int id) {
        String result = service.deleteStudent(id);

        if (result.equals("Student not found")) {
            return ResponseEntity.status(404).body(result);
        }

        return ResponseEntity.ok(result);
    }

    // ➤ Delete All Students
    @DeleteMapping("/deleteAll")
    public ResponseEntity<String> deleteAll() {
        String result = service.deleteAll();
        return ResponseEntity.ok(result);
    }
}