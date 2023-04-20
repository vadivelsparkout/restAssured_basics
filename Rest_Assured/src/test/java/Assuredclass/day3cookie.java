package Assuredclass;
import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

import static io.restassured.RestAssured.* ;
import static io.restassured.matcher.RestAssuredMatchers.* ;
import static org.hamcrest.Matchers.* ;

import java.util.Map;


public class day3cookie {

	//@Test
	void cookies() {
		
		
		given()
		
		
		.when()
		   .get("https://www.google.co.in/")
		
		.then()
		   .cookie("name of the cookie", "value of the cookie")//validating cookie
		   .log().all();
		
		
	}
	

	@Test
	void cookies_info() {
		
		
		Response res=given()//;after get -because then only it will return the response to "res"
		
		
		.when()
		   .get("https://www.google.co.in/");
		
		//get single cookie info
		//String cookie_value=res.getCookie("AEC");//NOT validation but it will get the value of that cookie
		//System.out.println(cookie_value);
		
		
		//get all cookie info
		Map<String, String> cookies = res.getCookies();
		System.out.println(cookies.keySet());//print only keys from Map
		
		for (String valuekey : cookies.keySet()) {
			
			String cookie_value=res.getCookie(valuekey);
			
			System.out.println(valuekey+"  "+cookie_value);
		
			
		}
		
	}
}
