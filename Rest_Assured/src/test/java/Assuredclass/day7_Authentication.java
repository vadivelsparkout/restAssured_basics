package Assuredclass;
import static io.restassured.RestAssured.* ;
import static io.restassured.matcher.RestAssuredMatchers.* ;
import static org.hamcrest.Matchers.* ;
import org.testng.annotations.Test;

public class day7_Authentication {
	//basic authentication
	@Test
	void auth1() {
		given()
		   .auth().basic("username", "passsword")
		   
		.when()
		   .get("url")
		.then()
		   .statusCode(200)
		   .body("authenticated msg",equalTo(true) );
	}
	
	//digest-same as basic
	@Test
	void auth2() {
		given()
		   .auth().digest("username", "passsword")
		   
		.when()
		   .get("url")
		.then()
		   .statusCode(200)
		   .body("authenticated msg",equalTo(true) );
	}
	
	//preemptive- combination of basic and digest
	@Test
	void auth3() {
		given()
		   .auth().preemptive().basic("username", "password")
		   
		.when()
		   .get("url")
		.then()
		   .statusCode(200)
		   .body("authenticated msg",equalTo(true) );
	}
	
	//bearer token
	@Test
	void auth4() {
		String bearertoken="token info";
		//even if we add bearer in auth it will show in request header-so we should give bearer token details in headers
		given()
		   .header("Authorization","Bearer "+bearertoken)
		.when()
		   .get("url")
		.then()
		   .statusCode(200)
		   .log().all();
	}
	//oauth1
	@Test
	void Auth1() {
		
		//oauth1
		given()
		   .auth().oauth("consumerKey", "consumerSecrat", "accessToken", "tokenSecrat")
		.when()
		   .get("url")
		.then()
		   .statusCode(200)
		   .log().all();
	}
	//oauth2
	@Test
	void Auth2() {
		
		
		given()
		   .auth().oauth2("token info")
		.when()
		   .get("url")
		.then()
		   .statusCode(200)
		   .log().all();
	}
	
	//API key-pass in queryparams
	@Test
	void APIkey() {
		
		//method 1
		given()
		   .queryParam("appid", "token info")//appid is a API key
		.when()
		   .get("https://api.openweathermap.org/data/2.5/forecast/daily?q=M%C3%BCnchen,DE&appid={API%20key}")
		.then()
		   .statusCode(200)
		   .log().all();
		
		//method 2-we can break the url into diff part
		given()
		 .queryParam("appid", "token info")
		 .pathParam("i can give any name", "/data/2.5/forecast/daily")
		 .queryParam("q", "London")
		 .queryParam("units", "metric")
		 .queryParam("cnt", "7")
		.when()
		  .get("https://api.openweathermap.org/{i can give any name}")
		.then()
		  .statusCode(200)
		  .log().all();
}
}
