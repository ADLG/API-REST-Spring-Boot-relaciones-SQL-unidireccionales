package com.api.rest.instructor.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.rest.instructor.entity.Instructor;

public interface RepoInstructor extends JpaRepository<Instructor, Long>{

}
