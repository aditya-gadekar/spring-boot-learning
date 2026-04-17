package com.aditya.demo2.Service;

import com.aditya.demo2.Entity.Course;
import com.aditya.demo2.Repo.CourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepo repo;

    // ➤ Add Course
    public Course addCourse(Course course) {
        return repo.save(course);
    }

    // ➤ Get All Courses
    public List<Course> getAllCourses() {
        return repo.findAll();
    }

    // ➤ Get Course by ID
    public Course getCourseById(int id) {
        return repo.findById(id).orElse(null);
    }

    // ➤ Delete Course
    public String deleteCourse(int id) {
        repo.deleteById(id);
        return "Course deleted";
    }
    public String deleteAll(){
        repo.deleteAll();
        return "All Courses deleted";
    }
}