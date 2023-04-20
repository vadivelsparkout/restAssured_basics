package Assuredclass;

import static io.restassured.RestAssured.given;
import org.testng.annotations.Test;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;



public class day3log_methods {
	
	

	@Test(priority = 1)
	void header() {
		
		
		given()
		
		
		.when()
		   .get("https://www.google.co.in/")
		
		.then()
		     .log().body()  //print only response body
		     .log().cookies()  //print only cookie from response
		     .log().headers()  //print only headers from respones
		     .log().status();   //pprint only status code
		    
}}
