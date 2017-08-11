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


public class LogResponses extends TestBase{

	
	
	//  log response header
	@Test
	public void testResponseLog1() {
		
		System.out.println("printing response header");
		given()
		.param("programme",  "Computer Science")
		.param("limit", 2)
		.when()
		.get("/list")
		.then()
		.log()
		.headers()
		.statusCode(200);
		
	}
	
	//  log response Status
	@Test
	public void testResponseLog2() {
		
		System.out.println("printing response status");
		given()
		.param("programme",  "Computer Science")
		.param("limit", 2)
		.when()
		.get("/list")
		.then()
		.log()
		.status()
		.statusCode(200);
		
	}	
	
//  log response body
	@Test
	public void testResponseLog3() {
		
		System.out.println("printing response body");
		given()
		.param("programme",  "Computer Science")
		.param("limit", 2)
		.when()
		.get("/list")
		.then()
		.log()
		.body()
		.statusCode(200);
		
	}	
	
//  log response in case of error
	@Test
	public void testResponseLog4() {
		
		System.out.println("printing response in the case of an error");
		given()
		.param("programme",  "Computer Science")
		.param("limit", -1)  // Give negative value to cause error in request
		.when()
		.get("/list")
		.then()
		.log()
		.ifError();
		
		
	}	
	
	
}
