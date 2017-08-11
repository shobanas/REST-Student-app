package com.students.tests;

import org.junit.BeforeClass;
import org.junit.Test;
import org.hamcrest.Matchers;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.student.base.TestBase;

public class StudentGetTest1 extends TestBase{

	
	
	@Test
	public void getAllStudentData() {
		
		Response response = RestAssured.given().
		when().
		get("/list");
		
		//  System.out.println(response.body().asString());
		System.out.println(response.body().prettyPrint());
		
		//validate the status code
		RestAssured.given()
		.when()
		.get("/list")
		.then()
		.statusCode(200);
		
	}
	
	@Test
	public void getSomeStudentInfo() {
		Response resp = RestAssured.given()
		.when()
		.get("/1");
		System.out.println(resp.body().prettyPrint());
		
		//validate the status code
		RestAssured.given()
		.when()
		.get("/1")
		.then()
		.statusCode(200);
		
	}
	
	@Test
	public void getStudentsFromFinance() {
		Response resp = RestAssured.given()
		.when()
		.get("/list?programme=Financial Analysis&limit=2");
		
		System.out.println(resp.body().prettyPeek());
		
		//validate the status code
		RestAssured.given()
		.when()
		.get("/list?programme=Financial Analysis&limit=2")
		.then()
		.statusCode(200);
		
		// better way to pass query string params
		Response resp2 = RestAssured.given()
		.param("programme", "Computer Science")
		.param("limit",  3)
		.when()
		.get("/list");
	
		System.out.println(resp2.body().prettyPeek());
		
	}
	
	
}
