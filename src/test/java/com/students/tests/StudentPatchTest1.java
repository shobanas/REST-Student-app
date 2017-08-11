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

public class StudentPatchTest1 extends TestBase {

	

	@Test
	public void updateStudentInfo() {
		ArrayList<String>  courseList = new ArrayList<> ();
		courseList.add("Java");
		courseList.add("Python");
		courseList.add("C++");
		
		
		// create an instance of student class
		
		StudentPojo student = new StudentPojo();
		student.setFirstName("Mark");
		student.setLastName("Taylor");
		student.setEmail("tHegde@gmail.com");
		student.setProgramme("Computer Science");
		
		student.setCourses(courseList);
		
		RestAssured.given()
		.contentType(ContentType.JSON)
		.when()
		.body(student)
		.put("/104")
		.then()
		.statusCode(200);
		
		
	}
	
}
