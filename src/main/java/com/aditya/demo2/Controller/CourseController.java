package com.aditya.demo2.Controller;

import com.aditya.demo2.Entity.Course;
import com.aditya.demo2.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService service;

    // ➤ Add Course
    @PostMapping("/add")
    public ResponseEntity<Course> addCourse(@RequestBody Course course) {
        Course savedCourse = service.addCourse(course);

        return ResponseEntity
                .created(URI.create("/course/" + savedCourse.getCourseId()))
                .body(savedCourse);
    }

    // ➤ Get All Courses
    @GetMapping("/all")
    public ResponseEntity<List<Course>> getAllCourses() {
        List<Course> courses = service.getAllCourses();

        if (courses.isEmpty()) {
            return ResponseEntity.noContent().build(); // 204
        }

        return ResponseEntity.ok(courses); // 200
    }

    // ➤ Get Course by ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getCourse(@PathVariable int id) {
        Course course = service.getCourseById(id);

        if (course == null) {
            return ResponseEntity.status(404).body("Course not found");
        }

        return ResponseEntity.ok(course);
    }

    // ➤ Delete Course by ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCourse(@PathVariable int id) {
        String result = service.deleteCourse(id);

        if (result.equals("Course not found")) {
            return ResponseEntity.status(404).body(result);
        }

        return ResponseEntity.ok(result);
    }

    // ➤ Delete All Courses
    @DeleteMapping("/deleteAll")
    public ResponseEntity<String> deleteAll() {
        String result = service.deleteAll();
        return ResponseEntity.ok(result);
    }
}