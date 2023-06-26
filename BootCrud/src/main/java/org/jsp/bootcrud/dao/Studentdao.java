package org.jsp.bootcrud.dao;

import java.util.List;
import java.util.Optional;

import org.jsp.bootcrud.dto.Student;
import org.jsp.bootcrud.helper.Responsestructure;
import org.jsp.bootcrud.repository.Studentrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class Studentdao {
   @Autowired
    Studentrepo repository;
	public Student save(Student student) {
		
		 return repository.save(student);
	}
	
	
	
	public List<Student> saveall(List<Student> students1) {
		return repository.saveAll(students1);
	}
	
	
	
	public List<Student> findall() {
		
		return repository.findAll();
	}
	
	
	
	public Optional<Student> findbyid(int id) {
		return repository.findById(id);
		
//		Optional<Student> op = repository.findById(id);
//		if(op.isPresent()) {
//			return op.get();
//		}else
//		return null;
	}
	
	
	
	public List<Student> fetchbyname(String name) {
		
		return repository.findByname(name);
	}
	
	
	
	public List<Student> findbymobile(long mobile) {
		
		return repository.findBymobile(mobile);
		
	}
	
	
	
	
	
	public List<Student> fetchbyresult(String result) {
		
		return repository.findByresult(result);
		
	}
	
	

	public void delete(int id) {
		repository.deleteById(id);
		
	}
	
	public void deleteall() {
	      repository.deleteAll();
	}
	
	
	
public List<Student> fetchbymathematics(int mathematics) {
		
		return repository.findBymathematicsGreaterThanEqual(mathematics);
		
	}
	
	public List<Student> findByphysicsGreaterThanEqual(int marks) {
		// TODO Auto-generated method stub
		return repository.findByphysicsGreaterThanEqual(marks);
	}
	public List<Student> findBycomputerscienceGreaterThanEqual(int marks) {
		// TODO Auto-generated method stub
		return repository.findBycomputerscienceGreaterThanEqual(marks);
	}
	
	
	
	
	public List<Student> findBymathematicsBetween(int marks1, int marks2) {
		// TODO Auto-generated method stub

		return repository.findBymathematicsBetween(marks1,marks2);
	}
	public List<Student> findByphysicsBetween(int marks1, int marks2) {
		// TODO Auto-generated method stub
//		return repository.findByphysicsGreaterThanEqualAndphysicsLessThanEqual(marks1,marks2);
//		return repository.findByphysicsBetween(marks1,marks2);
//		return repository.findphysicsBetween(marks1,marks2);
		return repository.findphysicsBetween1(marks1,marks2);
	}
	public List<Student> findBycomputerscienceBetween(int marks1, int marks2) {
		// TODO Auto-generated method stub
		return repository.findBycomputerscienceBetween(marks1,marks2);
	}



	



	

}
