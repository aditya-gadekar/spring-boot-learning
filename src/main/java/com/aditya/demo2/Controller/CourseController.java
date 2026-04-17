package com.aditya.demo2.Controller;

import com.aditya.demo2.Entity.Course;
import com.aditya.demo2.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService service;

    // ➤ Add Course
    @PostMapping("/add")
    public Course addCourse(@RequestBody Course course) {
        return service.addCourse(course);
    }

    // ➤ Get All Courses
    @GetMapping("/all")
    public List<Course> getAllCourses() {
        return service.getAllCourses();
    }

    // ➤ Get Course by ID
    @GetMapping("/{id}")
    public Course getCourse(@PathVariable int id) {
        return service.getCourseById(id);
    }

    // ➤ Delete Course
    @DeleteMapping("/delete/{id}")
    public String deleteCourse(@PathVariable int id) {
        return service.deleteCourse(id);
    }
    @DeleteMapping("/deleteAll")
    public String deleteAll(){
       return service.deleteAll();

    }
}