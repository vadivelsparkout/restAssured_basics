package Assuredclass;
import static io.restassured.RestAssured.* ;
import static io.restassured.matcher.RestAssuredMatchers.* ;
import static org.hamcrest.Matchers.* ;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.jsonschema.JsonSchema;

import io.restassured.matcher.RestAssuredMatchers;
import io.restassured.module.jsv.JsonSchemaValidator;

public class day6_schema_json {
	//first convert the response to schema by using online tool 
	//save it in your project
	
	@Test
	void json_schema() {
		
		
		given()
		
		.when()
		   .get("https://reqres.in/api/users?page=2")
		.then()
		    //JsonSchemaValidator-is a predefined class-schema should be in the resouses -otherwise this will not work
		   .assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("json_schema.json"));
	}
	
	
	@Test
	void xml_schema() {
		
		//xsd validation-file should be in resorses 
		//xml-xsd online tool to convert(xsd is a schema of xml)
		given()
		
		.when()
		   .get("https://reqres.in/api/users?page=2")
		.then()
		    //RestAssuredMatchers-is a predefined class-schema should be in the resouses -otherwise this will not work
		   .assertThat().body(RestAssuredMatchers.matchesXsdInClasspath("xsd_schema.xsd"));
	}

}
