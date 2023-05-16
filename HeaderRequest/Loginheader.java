package HeaderRequest;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class Loginheader {

	@Test(priority=1)
	void TestFlipkart() {
		given()
		
		.when()
		.get("https://www.flipkart.com/")
		
		.then()
			.log().all();
		
	}
	
	@Test(priority=2)
	void TestLogs() {
		given()
		
		.when()
		.get("https://reqres.in/api/users?page=2")
		
		.then()
			.log().all();
		
	}
	
}
