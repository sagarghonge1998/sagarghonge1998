package com.cjc.smcrud.service;

import java.util.List;

import com.cjc.smcrud.model.Student;

public interface HomeService {
	public void savedata(Student stu);

	public List<Student> dispalyAllData();


	
	public Student check(String uname, String password);
	
	public Student delete(int id);
	
	public Student edit (int id);
	
	public Iterable<Student> dispaly(String name);

}
