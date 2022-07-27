package com.cjc.smcrud.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cjc.smcrud.model.Student;
import com.cjc.smcrud.repository.MyRepository;
import com.cjc.smcrud.service.HomeService;

@Service
public class HomeServiceImpl implements HomeService {

	@Autowired
	private MyRepository rp;

	public void savedata(Student stu) {
		this.rp.save(stu);
		
	}

	public List<Student> dispalyAllData() {

		return rp.findAll();
	}

	@Override
	public Student check(String uname, String password) {

		Student st = rp.findAllByUnameAndPassword(uname, password);

		return st;
	}

	@Override
	public Student delete(int id) {

		Student st = rp.getById(id);

		rp.delete(st);

		return st;
	}

	@Override
	public Student edit(int uid) {

		Student st = rp.getById(uid);

		return st;
	}

	@Override
	public Iterable<Student> dispaly(String name) {

		return rp.findAllByName(name);
	}

	
}
