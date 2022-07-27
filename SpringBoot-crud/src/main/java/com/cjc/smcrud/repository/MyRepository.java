package com.cjc.smcrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cjc.smcrud.model.Student;

@Repository
public interface MyRepository extends JpaRepository<Student, Integer> {

	Student findAllByUnameAndPassword(String uname, String password);
	
	
	 public Iterable<Student> findAllByName(String name);

}
