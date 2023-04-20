package Assuredclass;
import static io.restassured.RestAssured.* ;
import static io.restassured.matcher.RestAssuredMatchers.* ;
import static org.hamcrest.Matchers.* ;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;
//how many ways to generate post request

//1.hasmp
//2.org.json
//using poja
//external file




public class day2 {
//post request body using hasmap
	
	
	//@Test(priority = 1)
	void has_map_post() {
		HashMap data1 =new HashMap();    //sending data -
		data1.put("name", "vijays");
		data1.put("job", "qas");
		
	    //String multi[]= {"new","value","pair"};//when one key had many value
	    //data1.putIfAbsent("course", multi);
	    
	    given()
	       .body(data1)
	       .contentType("application/json")
	    .when()
	        .post("https://reqres.in/api/users")
	    
	    .then()
	        .statusCode(201)
	        .body("name",equalTo("vijays"))
	        //.body("multi[0]",equalTo("new"))
	        //.body("multi[1]",equalTo("value"))
	        .log().all();
	        
	        
	}
	
	
	//org.json -method
	//@Test(priority = 1)
	void json_org_post() {
		
		JSONObject data=new JSONObject();//json dep should be added
		data.put("name","vijays");
		data.put("job","qas");
	    
	    given()
	       .body(data.toString())//can't directly pass json so convert to string then pass
	       .contentType("application/json")
	    .when()
	        .post("https://reqres.in/api/users")
	    
	    .then()
	        .statusCode(201)
	        .body("name",equalTo("vijays"))
	        .log().all();
	        
	        
	        
	        
	}
	
	
	//@Test(priority = 1)
	void pojoclass_post() {
		Day2_pojo_For data=new Day2_pojo_For();
		data.setName("vijays");
		data.setJob("qas");
		
		
		//if we want to send array value this method will use
		//String course[]= {"new","value","data"};
		//data.setCourse(course);
		
	    
	    given()
	       .body(data)//can't directly pass json so convert to string then pass
	       .contentType("application/json")
	    .when()
	        .post("https://reqres.in/api/users")
	    
	    .then()
	        .statusCode(201)
	        .body("name",equalTo("vijays"))
	        .log().all();
	    
	}
	
	
	
    //getting post from external file
	@Test(priority = 1)
	void external_post() throws FileNotFoundException {
		File f= new File(".//new.json");
		FileReader fr=new FileReader(f);
		JSONTokener frs=new JSONTokener(fr);
		JSONObject data=new JSONObject(frs);
		
		
	    
	    given()
	       .body(data.toString())//can't directly pass json so convert to string then pass
	       .contentType("application/json")
	    .when()
	        .post("https://reqres.in/api/users")
	    
	    .then()
	        .statusCode(201)
	        .body("name",equalTo("vijays"))
	        .log().all();
	    
	}
	
	@Test(priority = 2)
	void delete() {
		given()
		.when()
		    .delete("https://reqres.in/api/users/2")
		.then()
		    .statusCode(204);
	}
}
