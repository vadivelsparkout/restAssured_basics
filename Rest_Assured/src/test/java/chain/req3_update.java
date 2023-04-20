package chain;
import static io.restassured.RestAssured.* ;
import static io.restassured.matcher.RestAssuredMatchers.* ;
import static org.hamcrest.Matchers.* ;

import org.json.JSONObject;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;


public class req3_update {
	
	@Test
	void updateuser() {
	int id=0;
			Faker n=new Faker();
			String name=n.name().firstName();
			String email=n.internet().emailAddress();
			
			JSONObject data=new JSONObject();
			data.put("name", name);
			data.put("email", email);
			
			
			String tokenn="token info ";
			
			given()
				.header("Authorization","Bearer "+tokenn)
				.contentType("application/json")
				.pathParam("id", id)
				//.header(application.json)--//if we pass this in header
				.body(data.toString())
			.when()
				 .put("ur{id}")
			.then()	
			     .statusCode(200)
			     .log().all();
		}
	}

