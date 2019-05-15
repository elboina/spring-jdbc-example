package fr.worldline.spring.jdbc.dao.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import fr.worldline.spring.jdbc.dao.StudentDAO;
import fr.worldline.spring.jdbc.model.Student;
import fr.worldline.spring.jdbc.rowmapper.StudentMapper;

public class StudentJDBCTemplate implements StudentDAO {
	
	private DataSource dataSource;
	
	private JdbcTemplate jdbcTemplate;

	@Override
	public void setDataSource(DataSource dataSource) {
		// TODO Auto-generated method stub
		this.dataSource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(this.dataSource);

	}

	@Override
	public void create(String name, Integer age) {
		String query = "insert into student(name, age) values(?, ?)";
		this.jdbcTemplate.update(query, name, age);
		System.out.println("Created Record Name = " + name + " Age = "  + age);

	}

	@Override
	public Student getStudent(Integer id) {
		String query = "select * from student where id = ?";		
		return this.jdbcTemplate.queryForObject(query, new StudentMapper(), id);
	}

	@Override
	public List<Student> listStudents() {
		String query = "select * from student";
		return this.jdbcTemplate.query(query, new StudentMapper());
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Integer id, String name, Integer age) {
		// TODO Auto-generated method stub

	}

}
