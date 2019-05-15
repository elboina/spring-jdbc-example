package fr.worldline.spring.jdbc.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import fr.worldline.spring.jdbc.dao.StudentDAO;
import fr.worldline.spring.jdbc.dao.impl.StudentJDBCTemplate;

@Configuration
@PropertySource("classpath:persistence.properties")
public class JdbcConfiguration {
	
	@Autowired
	private Environment environment;
		
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(environment.getProperty("student.db.driverClassName"));
		dataSource.setUrl(environment.getProperty("student.db.url"));
		dataSource.setUsername(environment.getProperty("student.db.username"));
		dataSource.setPassword(environment.getProperty("student.db.password"));
		
		return dataSource;
	}
	
	@Bean
	public StudentDAO studentJDBCTemplate() {
		StudentJDBCTemplate studentJDBCTemplate = new StudentJDBCTemplate();
		studentJDBCTemplate.setDataSource(dataSource());
		return studentJDBCTemplate;
	}

}
