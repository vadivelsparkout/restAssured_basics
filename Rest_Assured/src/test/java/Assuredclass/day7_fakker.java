package Assuredclass;
import static io.restassured.RestAssured.* ;
import static io.restassured.matcher.RestAssuredMatchers.* ;
import static org.hamcrest.Matchers.* ;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;


public class day7_fakker {
	//we can generate data
	@Test
	void fakelib() {
		Faker n=new Faker();
		String name=n.name().firstName();
		String lastname=n.name().lastName();
		String email=n.internet().emailAddress();
		System.out.println(name+lastname+email);
	}

}
