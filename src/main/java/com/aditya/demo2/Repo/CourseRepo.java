package com.aditya.demo2.Repo;
import com.aditya.demo2.Entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepo extends JpaRepository<Course, Integer> {
}