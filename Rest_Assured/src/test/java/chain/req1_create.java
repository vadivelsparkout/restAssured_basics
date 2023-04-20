package chain;
import static io.restassured.RestAssured.* ;
import static io.restassured.matcher.RestAssuredMatchers.* ;
import static org.hamcrest.Matchers.* ;

import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;


public class req1_create {
	//only execute xml file ---id should be pass
	@Test
	void createuser(ITestContext variable) {
		Faker n=new Faker();
		String name=n.name().firstName();
		String email=n.internet().emailAddress();
		
		JSONObject data=new JSONObject();
		data.put("name", name);
		data.put("email", email);
		
		
		String tokenn="token info ";
		
		int id=given()
			.header("Authorization","Bearer "+tokenn)
			.contentType("application/json")
			//.header(application.json)--//if we pass this in header
			.body(data.toString())
			.when()
			 .post("ur")
			 .jsonPath().getInt("id");
		//id is only avaiable for test level not siut level
		variable.setAttribute("id", id);//this will make id available to other classes-global variable
			
		
		//this method will make id available for suit level
		variable.getSuite().setAttribute("id", id);
	}

}
