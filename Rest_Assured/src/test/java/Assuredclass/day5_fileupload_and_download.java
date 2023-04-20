package Assuredclass;
import static io.restassured.RestAssured.* ;
import static io.restassured.matcher.RestAssuredMatchers.* ;
import static org.hamcrest.Matchers.* ;

import java.io.File;

import org.testng.annotations.Test;


public class day5_fileupload_and_download {
	
	//fileuploading method
	@Test
    void fileupload() {
		File up=new File("path of the file");
		
	    given()
	       .multiPart("file",up)//represending form data
	       .contentType("multipart/form-data")//when you post file this content type
	    .when()
	     .post("url of the API")
	   .then()
	     .statusCode(200)
	     .body("message",equalTo( "additionalMetadata: new pet\nFile uploaded to ./music.jpg, 6323 bytes"))
	     .log().all();
	     
 }
	
	//@Test
    void fileuploadmultiple() {
		File up=new File("path of the file");
		File up2=new File("path of the file");
		
	    given()
	       .multiPart("files",up)//represending form data
	       .multiPart("files",up2)
	       .contentType("multipart/form-data")//when you post file this content type
	    .when()
	     .post("url of the API")
	   .then()
	     .statusCode(200)
	     .body("[0].files[0]",equalTo("name of the file"))//have to write json path to validate
	     .body("[0].files[1]",equalTo("name of the file"))
	     .log().all();
	     
 }
    @Test
    void fileuploadmultiple_array() {
    	
    	//in this way we don't need to create multiple  multipart when we need to upload more than one file
		File up=new File("path of the file");
		File up2=new File("path of the file");
		
		 File arr[]= {up,up2};//this will not suitable foer all
		
	    given()
	       .multiPart("files",arr)//represending form data
	       .contentType("multipart/form-data")//when you post file this content type
	    .when()
	     .post("url of the API")
	   .then()
	     .statusCode(200)
	     .body("[0].files[0]",equalTo("name of the file"))//have to write json path to validate
	     .body("[0].files[1]",equalTo("name of the file"))
	     .log().all();
    }
    
    @Test
    void download() {//if we want multiple download you have to write multiple test
    	given()
    	.when()
    	   .get("file url from the response above request")
    	.then()
    	   .statusCode(200)
    	   .log().body();
    }

}
