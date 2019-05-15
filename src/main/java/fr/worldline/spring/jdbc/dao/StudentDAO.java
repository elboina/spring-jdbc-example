package fr.worldline.spring.jdbc.dao;

import java.util.List;

import javax.sql.DataSource;

import fr.worldline.spring.jdbc.model.Student;

public interface StudentDAO {
	
	void setDataSource(DataSource dataSource);
	
	void create(String name, Integer age);
	
	Student getStudent(Integer id);
	
	List<Student> listStudents();
	
	void delete(Integer id);
	
	void update(Integer id, String name, Integer age);

}
