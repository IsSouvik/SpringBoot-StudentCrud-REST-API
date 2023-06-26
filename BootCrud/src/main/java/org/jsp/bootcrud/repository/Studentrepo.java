package org.jsp.bootcrud.repository;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.jsp.bootcrud.dto.Student;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;

public interface Studentrepo extends JpaRepository<Student, Integer>  {

	List<Student> findByname(String name);

	List<Student> findBymobile(long mobile);

    List<Student> findBymathematicsGreaterThanEqual(int mathematics);

	List<Student> findByresult(String result);

	List<Student> findByphysicsGreaterThanEqual(int marks);

	List<Student> findBycomputerscienceGreaterThanEqual(int marks);


//1
//	List<Student> findByphysicsGreaterThanEqualAndphysicsLessThanEqual(int marks1,int marks2);

//2
	List<Student> findByphysicsBetween(int marks1, int marks2);
//3	
	@Query("select x from Student x where physics between ?1 and ?2")
	List<Student> findphysicsBetween(int marks1,int marks2);
//4
	@Query(nativeQuery = true,value = "select * from student where physics between ?1 and ?2")
	List<Student>findphysicsBetween1(int marks1,int marks2);
	

	List<Student> findBymathematicsBetween(int marks1, int marks2);

	List<Student> findBycomputerscienceBetween(int marks1, int marks2);

}

