package Assuredclass;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.* ;
import static io.restassured.matcher.RestAssuredMatchers.* ;
import static org.hamcrest.Matchers.* ;

import java.util.HashMap;

//given()-prerequisites (content type,cookies, add auth,add params,add headers)
//when()-request type
//then()-validation(code,header,key , value)
public class day1 {
	
	int id; //getting value from one request then give that value to another request 
	
	
	@Test(priority = 1)
	public void getrequest() {
		given()                             //first  method don't start with .   
		                                     //get https://reqres.in/api/users?page=2
		.when()
		  .get("https://reqres.in/api/users?page=2")
		
		.then()//assertion to check the results
		  .statusCode(200)
		  .body("page",equalTo(2))
		  .log().all();
		
	}
	@Test(priority = 2)
	void posrequest() {
		
		HashMap data =new HashMap();    //sending data -
		data.put("name", "vijay");
		data.put("job", "qa");
		
		
		
		id=given()
		  .contentType("application/json")
		  .body(data)
		.when()
		  .post("https://reqres.in/api/users")
		  .jsonPath().getInt("id");//getting value of id this method
	   	//.then()
		  //.statusCode(201)
		  //.log().all();
	}
	@Test(priority = 3,dependsOnMethods = {"posrequest"})
	void putrequest() {
		
		HashMap data1 =new HashMap();    //sending data -
		data1.put("name", "vijays");
		data1.put("job", "qas");
		
		
		
		given()
		  .contentType("application/json")
		  .body(data1)
		.when()
		  .put("https://reqres.in/api/users/"+id)//get value of id from previous request
	   	.then()
		  .statusCode(200)
		  .log().all();	
		
	}
	@Test(priority = 4)
	void deleterequest() {
		given()
		
		.when()
		  .delete("https://reqres.in/api/users/"+id)
		  
		.then()  
		  .statusCode(204)
		  .log().all();
	}

}
