package org.jsp.bootcrud.controller;

import java.util.List;

import org.jsp.bootcrud.dto.Student;
import org.jsp.bootcrud.helper.Responsestructure;
import org.jsp.bootcrud.service.Sudentservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Studentcontroller {
	@Autowired
	Sudentservice service;
	@PostMapping("studentone")
	public Responsestructure<Student> save(@RequestBody Student student) {
		return service.save(student);
	}
	@PostMapping("studentmany")
	public Responsestructure<List<Student>> saveall(@RequestBody List<Student> students) {
		return service.saveall(students);
	}
	@GetMapping("studentall")
	public Responsestructure<List<Student>> findall(){
		return service.findall();
	}
	@GetMapping("studentone")
	public Responsestructure<Student> fetchbyid(@RequestParam int id) {
		return service.fetchbyid(id);
	}
	@GetMapping("studentsn/{name}")
	public Responsestructure<List<Student>> fetchbyname(@PathVariable String name) {
		return service.fetchbyname(name);
	}
	@GetMapping("studentsm/{mobile}")
	public Responsestructure<List<Student>> fetchbymobile(@PathVariable long mobile) {
		return service.fetchbymobile(mobile);
	}
	@GetMapping("studentsr/{result}")
	public Responsestructure<List<Student>> fetchbymobile(@PathVariable String result) {
		return service.fetchbyresult(result);
	}
	
	@GetMapping("studentsmath/{mathematics}")
	public Responsestructure<List<Student>> fetchbymathematics(@PathVariable int mathematics) {
		
		return service.fetchbymathematics(mathematics);
		
	}
	@GetMapping("studentd/{id}")
	public Responsestructure<Student> deletebyid(@PathVariable int id) {
		return service.deletebyid(id);
	}
	@GetMapping("studentdall/{id}")
	public Responsestructure<List<Student>> deleteall() {
		return service.deleteall();
	}
	@GetMapping("students/{subject}/{marks}")
	public Responsestructure<List<Student>> fetchbysubject(@PathVariable String subject,@PathVariable int marks) {
		
		return service.fetchbysubject(subject,marks);
		
	}
	@GetMapping("students/{subject}/{marks1}/{marks2}")
	public List<Student> fetchbysubjects(@PathVariable String subject,@PathVariable int marks1,@PathVariable int marks2) {
		
		return service.fetchbysubjects(subject,marks1,marks2);
		
	}

}
