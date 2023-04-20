package Assuredclass;
import static io.restassured.RestAssured.* ;
import static io.restassured.matcher.RestAssuredMatchers.* ;
import static org.hamcrest.Matchers.* ;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;


public class day5_prasing_xml {
    //a
	@Test
	void xmlparsing() {
		//approach 1-xml validation
		
		/*given()
		.when()
		.get("http://restapi.adequateshop.com/api/Traveler")
		.then()
		.body("TravelerinformationResponse.page", equalTo("1"))
		.statusCode(200)
		.header("content-type", "application/xml; charset=utf-8");*/
		
		
		//approach 2-xml validation
	Response res=given()
		.when()
		.get("http://restapi.adequateshop.com/api/Traveler");
	
	Assert.assertEquals(res.statusCode(),200);
	Assert.assertEquals(res.header("content-type"),"application/xml; charset=utf-8");
	String result=res.xmlPath().get("TravelerinformationResponse.page").toString();
	Assert.assertEquals(result,"1");	
	
	}
	
	@Test
	//approach 3
	void xmlparsing2() {
		Response res1=given()
				.when()
				.get("http://restapi.adequateshop.com/api/Traveler");
		
		XmlPath xml=new XmlPath(res1.asString());
		
		//verify totall number of travellers
		List<String> detail=xml.getList("TravelerinformationResponse.travelers.Travelerinformation");
		Assert.assertEquals(detail.size(),10);
		
		
		Boolean status= false ;
		//verify perticular name is presented or not
		List<String> detail1=xml.getList("TravelerinformationResponse.travelers.Travelerinformation.name");
		for (String name : detail1) {
			System.out.println(name);
			if(name.equals("vano")) {
				System.out.println(name+"   is present");
				status =true;
				break ;
			}
		}
		
	}
	
	
	
	
	
}
