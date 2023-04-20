package chain;
import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;


public class req4_delete{
	//try to do more because it bit confusing
	
	@Test
	void deleteuser() {
		String tokenn="token info ";
		int id=0;
		
		given()
		.header("Authorization","Bearer "+tokenn)
		.pathParam("id", id)
		.when()
		.delete("url{id}")
		.then()
		.statusCode(204)
		.log().all();
	}

}
