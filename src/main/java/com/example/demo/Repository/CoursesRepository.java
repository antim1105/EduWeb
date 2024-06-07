package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Courses;

public interface CoursesRepository extends JpaRepository<Courses, Integer>{

}
