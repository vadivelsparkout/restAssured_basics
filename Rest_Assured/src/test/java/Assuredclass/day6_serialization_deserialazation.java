package Assuredclass;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import static io.restassured.RestAssured.* ;
import static io.restassured.matcher.RestAssuredMatchers.* ;
import static org.hamcrest.Matchers.* ;

import javax.xml.crypto.Data;

public class day6_serialization_deserialazation {
	//jackson lib for that
	
	
	//@Test
	void ppojoseriaal() throws JsonProcessingException {
		
	//created java object using pojo class
	Day2_pojo_For data=new Day2_pojo_For();
	data.setName("vijays");
	data.setJob("qas");
	
	//convert java object to json objects-import from jackson pakage
	ObjectMapper obj=new ObjectMapper();
	String json=obj.writerWithDefaultPrettyPrinter().writeValueAsString(data);
	System.out.println(json);

}
	@Test
	void deserialization() throws JsonMappingException, JsonProcessingException {
		String jsondata="{\r\n"
				+ "  \"name\" : \"vijays\",\r\n"
				+ "  \"course\" : null,\r\n"
				+ "  \"job\" : \"qas\"\r\n"
				+ "}";
		
		//convert json inti java object 
		ObjectMapper obj2=new ObjectMapper();
		
		//Day2_pojo_For -pojo class
		Day2_pojo_For  obj3=obj2.readValue(jsondata,Day2_pojo_For.class );
		//get methods to get data from poja
		String name = obj3.getName();
		System.out.println(name);
		
	}
}
