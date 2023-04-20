package Assuredclass;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.* ;
import static io.restassured.matcher.RestAssuredMatchers.* ;
import static org.hamcrest.Matchers.* ;

public class day3 {
	//https://reqres.in/api/users?page=2&id=5
	//path parameter -key & value pair
	@Test
	void query_path_parameter() {
		
		
		given()
		   .pathParam("mypath", "users")
		   .queryParam("page", 2)
		   .queryParams("id", 5)
		
		.when()
		   .get("https://reqres.in/api/{mypath}")//pathpara mustnot be hardcoded but querypara can
		                                         //no need to add query para in get request if we declare qp in given it will send along with get
		.then()
		   .statusCode(200) 
		   .log().all();
	}

}
