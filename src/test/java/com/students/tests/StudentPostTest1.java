package com.students.tests;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;

import org.hamcrest.Matchers;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import com.student.base.TestBase;
import com.student.model.StudentPojo;

public class StudentPostTest1  extends TestBase{

	

	@Test
	public void createStudentInfo() {
		ArrayList<String>  courseList = new ArrayList<> ();
		courseList.add("Java");
		courseList.add("Python");
		courseList.add("C");
		
		
		/************* create an instance of student class
		
		Student student = new Student();
		student.setFirstname("xxx");
		student.setLastname("yyy");
		student.setEmail("xyxy@gmail.com");
		student.setProgramme("Computer Science");
		
		student.setCourses(courseList);
		
		RestAssured.given()
		.contentType(ContentType.JSON)
		.when()
		.body(student)
		.post()
		.then()
		.statusCode(201);
		
		***************/
		
		
		// create an instance of student class

		StudentPojo student = new StudentPojo();
		student.setFirstName("MD");
		student.setLastName("Sim");
		student.setEmail("tej@tmail.com");
		student.setProgramme("Computer Science");

		student.setCourses(courseList);

		RestAssured.given()
		.log()
		.all()
		.contentType(ContentType.JSON)
		.when()
		.body(student)
		.post()
		.then()
		.log()
		.all()
		.statusCode(201);

		}
		
	}
	
	
	

