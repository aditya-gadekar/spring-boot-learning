package com.aditya.demo2.Repo;
import com.aditya.demo2.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student, Integer> {
}