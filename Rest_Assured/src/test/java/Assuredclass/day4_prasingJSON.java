package Assuredclass;


import static io.restassured.RestAssured.* ;
import static io.restassured.matcher.RestAssuredMatchers.* ;
import static org.hamcrest.Matchers.* ;//then assertion comes from this import

import java.util.Iterator;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class day4_prasingJSON {
	
	//Approach 1
	//@Test
	void testjsonresponsedata() {
		
		given()
		  //  .contentType(ContentType.JSON)-specify contentent type 
		
		.when()
		  .get("https://reqres.in/api/{resource}?page=3&per_page=10")
		
		.then()
		  .body(".support.text",equalTo("To keep ReqRes free, contributions towards server costs are appreciated!"));
		}
	
	    //Approach 2
	    //@Test
		void testjsonresponsedata1() {
			
			Response res=given()
			
			
			.when()
			  .get("https://reqres.in/api/{resource}?page=3&per_page=10");
			
			//testng validation
			Assert.assertEquals(res.statusCode(),"200");
			Assert.assertEquals(res.header("content-type"),"application/json");
			String test=res.jsonPath().get(".support.text").toString();
			Assert.assertEquals(test, "To keep ReqRes free, contributions towards server costs are appreciated!");
			
			

}
		//Approach 3
		@Test
		void testjsonresponsedata2() {
			
			Response res=given()//resonse in Response format ,so convert into string then to jsonobject for parsing
					            //res.toString()- convert Response to String
			
			
			.when()
			  .get("https://reqres.in/api/users");
			
			
			JSONObject j=new JSONObject(res.asString());//coverting response to json object
			
			Boolean value=false;
			for(int i=0;i<(j.getJSONArray("data").length());i++) {
				//first get json array-in that array get that all set of data -after get the perticular key -convert it to string
				String emil=j.getJSONArray("data").getJSONObject(i).getString("email").toString();
				
				System.out.println(emil);
				
				
				//if we want to check only perticular value presented or not
				if (emil.equals("eve.holt@reqres.in")) {
					value=true;
					break ;
				}
				Assert.assertEquals(value, true);
				
				
				//if we want to convert string to int or double
				//Double.parseDouble(emil);-import must know
			}
		}
		
			}


