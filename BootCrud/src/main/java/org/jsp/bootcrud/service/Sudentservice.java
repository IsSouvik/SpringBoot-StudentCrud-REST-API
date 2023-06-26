package org.jsp.bootcrud.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.jsp.bootcrud.dao.Studentdao;
import org.jsp.bootcrud.dto.Student;
import org.jsp.bootcrud.helper.Responsestructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class Sudentservice {
	@Autowired
	Studentdao dao;

	public Responsestructure<Student> save(Student student) {
		int total = student.getPhysics() + student.getComputerscience() + student.getMathematics();
		student.setTotal(total);
		double percentage = total / 3.0;
		student.setPercentage(percentage);
		if (student.getPhysics() < 35 || student.getMathematics() < 35 || student.getComputerscience() < 35) {
			student.setResult("fail");
		} else {
			if (percentage > 85) {
				student.setResult("Distinction");
			} else if (percentage > 60)
				student.setResult("First Class");
			else
				student.setResult("Second Class");
		}
		Responsestructure<Student>structure=new Responsestructure<>();
		structure.setMessage("data saved successfully");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setData(dao.save(student));
		return structure;
	}

	
	public Responsestructure<List<Student>> saveall(List<Student> students) {
		for (Student students1 : students) {
			int total = students1.getPhysics() + students1.getComputerscience() + students1.getMathematics();
			students1.setTotal(total);
			double percentage = total / 3.0;
			students1.setPercentage(percentage);
			if (students1.getPhysics() < 35 || students1.getMathematics() < 35 || students1.getComputerscience() < 35) {
				students1.setResult("fail");
			} else {
				if (percentage > 85) {
					students1.setResult("Distinction");
				} else if (percentage > 60)
					students1.setResult("First Class");
				else
					students1.setResult("Second Class");
			}

		}

		Responsestructure<List<Student>>structure=new Responsestructure<>();
		structure.setMessage("data saved successfully");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setData(dao.saveall(students));
		return structure;
	}

	
	
	public Responsestructure<List<Student>> findall() {

		List<Student>student=dao.findall();
		Responsestructure<List<Student>>structure=new Responsestructure<>();
		if(student.isEmpty()) {
			structure.setMessage("data not found");
			structure.setStatus(HttpStatus.NOT_FOUND.value());
		
		}else {
			structure.setMessage("data found");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(student);

		}
		return structure;
	}

	
	
	public Responsestructure<Student> fetchbyid(int id) {
		Optional<Student>op= dao.findbyid(id);
		Responsestructure<Student>structure=new Responsestructure<>();
		if(op.isEmpty()) {
			structure.setMessage("data not found");
			structure.setStatus(HttpStatus.NOT_FOUND.value());
		
		}else {
			structure.setMessage("data found");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(op.get());

		}
		return structure;
		
	}
	
	
	

	public Responsestructure<List<Student>> fetchbyname(String name) {

		List<Student>list= dao.fetchbyname(name);
		Responsestructure<List<Student>>structure=new Responsestructure<>();
		if(list.isEmpty()) {
			structure.setMessage("data not found");
			structure.setStatus(HttpStatus.NOT_FOUND.value());
		
		}else {
			structure.setMessage("data found");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(list);

		}
		return structure;
	}

	
	
	public Responsestructure<List<Student>>fetchbymobile(long mobile) {

		List<Student>list= dao.findbymobile(mobile);
		Responsestructure<List<Student>>structure=new Responsestructure<>();
		if(list.isEmpty()) {
			structure.setMessage("data not found");
			structure.setStatus(HttpStatus.NOT_FOUND.value());
		
		}else {
			structure.setMessage("data found");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(list);

		}
		return structure;
	}

	
	
	public Responsestructure<List<Student>> fetchbymathematics(int mathematics) {

		List<Student>list= dao.fetchbymathematics(mathematics);
		Responsestructure<List<Student>>structure=new Responsestructure<>();
		if(list.isEmpty()) {
			structure.setMessage("data not found");
			structure.setStatus(HttpStatus.NOT_FOUND.value());
		
		}else {
			structure.setMessage("data found");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(list);

		}
		return structure;
	}

	
	
	
	public Responsestructure<List<Student>>  fetchbyresult(String result) {
		List<Student>list= dao.fetchbyresult(result);
		Responsestructure<List<Student>>structure=new Responsestructure<>();
		if(list.isEmpty()) {
			structure.setMessage("data not found");
			structure.setStatus(HttpStatus.NOT_FOUND.value());
		
		}else {
			structure.setMessage("data found");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(list);

		}
		return structure;
	}

	
	
	
	public Responsestructure<Student> deletebyid(int id) {
		// TODO Auto-generated method stub
		Responsestructure<Student>structure=new Responsestructure<>();
		Optional<Student>op= dao.findbyid(id);
		if(op.isEmpty()) {
			structure.setMessage("data not found");
			structure.setStatus(HttpStatus.NOT_FOUND.value());
			
		}else {
			dao.delete(id);
			structure.setMessage("data deleted");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(op.get());
		}
		return structure;
	}

	
	
	
	public Responsestructure<List<Student>> deleteall() {
		// TODO Auto-generated method stub
		Responsestructure<List<Student>>structure=new Responsestructure<>();
		List<Student>list=dao.findall();
		if(list.isEmpty()) {
			structure.setMessage("data not found");
			structure.setStatus(HttpStatus.NOT_FOUND.value());	
		}else {
			dao.deleteall();
			structure.setMessage("all data deleted");
	        structure.setStatus(HttpStatus.OK.value());
	        structure.setData(list);
		}
		return structure;
		    
	}
	
	
	
	
	public Responsestructure<List<Student>> fetchbysubject(String subject, int marks) {

		if (subject.equals("mathematics")) {
			List<Student>list= dao.fetchbymathematics(marks);
			Responsestructure<List<Student>>structure=new Responsestructure<>();
			if(list.isEmpty()) {
				structure.setMessage("data not found");
				structure.setStatus(HttpStatus.NOT_FOUND.value());
			
			}else {
				structure.setMessage("data found");
				structure.setStatus(HttpStatus.FOUND.value());
				structure.setData(list);

			}
			return structure;
		} else if (subject.equals("physics")) {
			List<Student>list= dao.findByphysicsGreaterThanEqual(marks);
			Responsestructure<List<Student>>structure=new Responsestructure<>();
			if(list.isEmpty()) {
				structure.setMessage("data not found");
				structure.setStatus(HttpStatus.NOT_FOUND.value());
			
			}else {
				structure.setMessage("data found");
				structure.setStatus(HttpStatus.FOUND.value());
				structure.setData(list);

			}
			return structure;
		} else
		if(subject.equals("computerscience")) {
		List<Student>list=dao.findBycomputerscienceGreaterThanEqual(marks);
		Responsestructure<List<Student>>structure=new Responsestructure<>();
		if(list.isEmpty()) {
			structure.setMessage("data not found");
			structure.setStatus(HttpStatus.NOT_FOUND.value());
		
		}else {
			structure.setMessage("data found");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(list);

		}
		return structure;
		}else {
			return null;
		}
	}

	
	
	
	public List<Student> fetchbysubjects(String subject, int marks1, int marks2) {
		if (subject.equals("mathematics")) {
			return dao.findBymathematicsBetween(marks1, marks2);
		} else if (subject.equals("physics")) {
			return dao.findByphysicsBetween(marks1, marks2);
		} else
			return dao.findBycomputerscienceBetween(marks1, marks2);
	}


	
}
