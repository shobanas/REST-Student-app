package com.students.tests;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;

import org.hamcrest.Matchers;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import com.student.base.TestBase;
import com.student.model.Student;

public class StudentDeleteTest1  extends TestBase{



	@Test
	public void deleteStudent() {
		RestAssured.given()
		.when()
		.delete("/104")
		.then()
		.statusCode(204);
		
		
	}
	
	
}
