package Assuredclass;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import static io.restassured.RestAssured.* ;
import static io.restassured.matcher.RestAssuredMatchers.* ;
import static org.hamcrest.Matchers.* ;

import org.json.JSONObject;

public class day8_APIchain {
//chainning in rest assured
	@Test
	void createt_user() {
		Faker n=new Faker();
		String name=n.name().firstName();
		String email=n.internet().emailAddress();
		
		JSONObject data=new JSONObject();
		data.put("name", name);
		data.put("email", email);
		
		String tokenn="token info ";
		
	Integer id=given()
		.header("Authorization","Bearer "+tokenn)
		.contentType("application/json")
		//.header(application.json)--//if we pass this in header
		.body(data.toString())
		.when()
		 .post("ur")
		 .jsonPath().getInt("id");
		
		
		
		
	}
	
	
}
