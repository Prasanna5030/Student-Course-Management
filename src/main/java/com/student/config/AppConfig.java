package com.student.config;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@ComponentScan(basePackages = "com.student")
@Configuration
public class AppConfig {
	
	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver= new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
	

	@Bean
	public JdbcTemplate jdbcTemplate() throws SQLException  {
		
		JdbcTemplate jdbcTemplate= new JdbcTemplate(dataSource());
		return jdbcTemplate;
	}
	

	@Bean
	public DataSource dataSource() throws SQLException {
		FileReader fr;
		Properties properties=null;
		try {
			fr = new FileReader("C:\\Users\\HP\\eclipse-workspace\\StudentMangament\\db.properties");
		    properties= new Properties();
			properties.load(fr);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUrl(properties.getProperty("url"));
		dataSource.setUsername(properties.getProperty("username"));
		dataSource.setPassword(properties.getProperty("password"));
		dataSource.setDriverClassName(properties.getProperty("driver"));
		
//		DataSource dataSource = new DriverManagerDataSource("jdbc:mysql://localhost:3306/college, root, Prasanna@5030");
//		
//		try {
//			dataSource.getConnection();
//			
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	
		
		
		return dataSource; 
	}
}
