package Assuredclass;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.* ;
import static io.restassured.matcher.RestAssuredMatchers.* ;
import static org.hamcrest.Matchers.* ;
import org.testng.annotations.Test;


import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;


public class day3Header {
	
	
	    //@Test(priority = 1)
		void header() {
			
			
			given()
			
			
			.when()
			   .get("https://www.google.co.in/")
			
			.then()
			   .header("name of the header", "value of the header")//header vlidation
			   //.and()//when having multiple validation but not nessasary 
			   .log().headers();//it will return only headers in the response
			
			
		}
	    
	    
	    @Test(priority = 1)
		void header1() {
			
			
		Response res=given()
			
			
			.when()
			   .get("https://www.google.co.in/");
			
		//get single header info
		String value=res.getHeader("Content-Type");
		System.out.println("the value of header is :"+value);
		
		//get value of all headers
		Headers headers=res.getHeaders();
		
		for (Header hd : headers) {
			System.out.println("all header onebyone"+hd.getName()+" "+hd.getValue());//getname and getvalue method only for headers
			//this method is not so useful because log().all() -will print all head value 
		}
			
			
		}
}
