package com.students.logging;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.hamcrest.Matchers.*;

import java.util.ArrayList;

import static com.jayway.restassured.RestAssured.*;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import com.student.base.TestBase;
import com.student.model.StudentPojo;


public class LogRequests extends TestBase{

	//  log request header
	@Test
	public void testReqLog1() {
		
		System.out.println("printing request headers");
		given()
		.log()
		.headers()
		.when()
		.get("/1")
		.then()
		.statusCode(200);
		
	}
	
	//  log request params
	@Test
	public void testReqLog2() {
		
		System.out.println("printing request parameters");
		given()
		.param("programme",  "Computer Science")
		.param("limit", 2)
		.log()
		.params()
		.when()
		.get("/list")
		.then()
		.statusCode(200);
		
	}
	
	// log request body
	@Test
	public void testReqLog3 () {
		
		System.out.println("printing request body");
		
		ArrayList<String>  courseList = new ArrayList<> ();
		courseList.add("Java");
		courseList.add("Python");
		courseList.add("C");
	
		
		// create an instance of student class

		StudentPojo student = new StudentPojo();
		student.setFirstName("KK");
		student.setLastName("Swam");
		student.setEmail("kk@kmail.com");
		student.setProgramme("Computer Science");

		student.setCourses(courseList);

		RestAssured.given()
		.contentType(ContentType.JSON)
		.log()
		.body()
		.when()
		.body(student)
		.post()
		.then()
		.log()
		.all()
		.statusCode(201);

	}
	
	// log all details about request
		@Test
		public void testReqLog4 () {
			
			System.out.println("printing all request details");
			
			ArrayList<String>  courseList = new ArrayList<> ();
			courseList.add("Java");
			courseList.add("Python");
			courseList.add("C");
		
			
			// create an instance of student class

			StudentPojo student = new StudentPojo();
			student.setFirstName("GK");
			student.setLastName("Swam");
			student.setEmail("GK@Gmail.com");
			student.setProgramme("Computer Science");

			student.setCourses(courseList);

			RestAssured.given()
			.contentType(ContentType.JSON)
			.log()
			.all()
			.when()
			.body(student)
			.post()
			.then()
			.log()
			.all()
			.statusCode(201);
			
		}
		
		// log all details when the test validation fails
		@Test
		public void testReqLog5 () {
			
			System.out.println("printing request details when test fails");
			
			ArrayList<String>  courseList = new ArrayList<> ();
			courseList.add("Java");
			courseList.add("Python");
			courseList.add("C");
		
			
			// create an instance of student class

			StudentPojo student = new StudentPojo();
			student.setFirstName("KK");
			student.setLastName("Swam");
			student.setEmail("kk@kmail.com");
			student.setProgramme("Computer Science");

			student.setCourses(courseList);

			RestAssured.given()
			.contentType(ContentType.JSON)
			.log()
			.ifValidationFails()
			.when()
			.body(student)
			.post()
			.then()
			.log()
			.all()
			.statusCode(201);

		}
		
		
		
		
	
	
}
