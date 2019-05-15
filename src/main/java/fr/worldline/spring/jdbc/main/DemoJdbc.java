package fr.worldline.spring.jdbc.main;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.worldline.spring.jdbc.dao.impl.StudentJDBCTemplate;
import fr.worldline.spring.jdbc.model.Student;

public class DemoJdbc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = (ApplicationContext) new ClassPathXmlApplicationContext("context-beans.xml");
		StudentJDBCTemplate studentJdbcTemplate = (StudentJDBCTemplate) context.getBean("studentJDBCTemplate");
		
		/* System.out.println("Create first student");
		studentJdbcTemplate.create("Abdesslem", 20);
		System.out.println("Create second student");
		studentJdbcTemplate.create("Aymen", 2);
		System.out.println("Create third student");
		studentJdbcTemplate.create("Imen", 11); */
		
		Student student = studentJdbcTemplate.getStudent(2);
		
		System.out.println("Etudiant récupéré : " + student.getName());
		
		List<Student> students = studentJdbcTemplate.listStudents();
		
		students.forEach(s -> System.out.println(s.getName()));

	}

}
