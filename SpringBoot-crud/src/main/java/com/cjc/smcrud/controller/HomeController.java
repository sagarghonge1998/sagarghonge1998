package com.cjc.smcrud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cjc.smcrud.model.Student;
import com.cjc.smcrud.service.HomeService;

@Controller
public class HomeController {
	Student s = new Student();

	@Autowired
	private HomeService hm;

	@RequestMapping("/")
	public String homepage(Model m) {

		return "login";
	}

	@RequestMapping("/login")
	public String login(Model m, @ModelAttribute Student st) {
		Student s=hm.check(st.getUname(), st.getPassword());
		if(s!=null) {

		m.addAttribute("data", hm.dispalyAllData());
		return "success";
	}
		else
		{
			return "login";
		}
	}

	@RequestMapping("/regi")
	public String preRegister() {

		return "registration";
	}

	@GetMapping("/reg")
	public String registerData(@ModelAttribute Student stu, Model m) {
		m.addAttribute("user", stu);

		hm.savedata(stu);
		return "login";
	}

	@GetMapping("/update")
	public String updatedata(@ModelAttribute Student st, Model m) {
	    hm.savedata(st);
		m.addAttribute("data", hm.dispalyAllData());
		return "success";
	}
	
	@GetMapping("/edit")
	public String editdata(@RequestParam("uid") int s, Model m) {

		Student st = hm.edit(s);
		
		m.addAttribute("data", st);
		return "edit";
	}
	
	@GetMapping("/delete")
	public String deletedata(@RequestParam("uid") int s,Model m) {

		Student st = hm.delete(s);
		m.addAttribute("data", hm.dispalyAllData());
	
		return "success";
	}

	@GetMapping("/sort")
	public String sort() {

		return "sort";
	}
	@GetMapping("/loc")
	public String show(@RequestParam("name") String st,Model m) {

		Iterable< Student> q=hm.dispaly(st);
		
		m.addAttribute("data", q);
	
		return "success2";
	}
	

}
