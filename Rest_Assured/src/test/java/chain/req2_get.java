package chain;
import static io.restassured.RestAssured.* ;
import static io.restassured.matcher.RestAssuredMatchers.* ;
import static org.hamcrest.Matchers.* ;

import org.testng.ITestContext;
import org.testng.annotations.Test;


public class req2_get {
	
	@Test
	void getuser(ITestContext  variable ) {
		//this method will get only test level variavle
		int id=(Integer) variable.getAttribute("id");//this should come from another test -create user
		
		//this method will access suit level variable
		variable.getSuite().getAttribute("id");
		
		String tokenn="token info ";
		
		given()
		   .header("Authorization","Bearer "+tokenn)
		   .pathParam("id", tokenn)
		.when()
		   .get("url{id}")
		.then()
		   .statusCode(200)
		   .log().all();
	}

}
