package HeaderRequest;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.apache.hc.core5.http.Header;
import org.testng.annotations.Test;


import io.restassured.http.Headers;
import io.restassured.response.Response;

public class AllHeaderRequest {


	//Header
	
	@Test(priority=1)
	void testHeaders() 
	{
				given()
				
				.when()
				.get("https://www.google.com/")

				.then()
				.header("Content-Type","text/html; charset=ISO-8859-1")
				.and()
				.header("Content-Encoding","gzip")
				.and()
				.header("P3P","CP=\"This is not a P3P policy! See g.co/p3phelp for more info.\"")
				.and()
				.header("Server", "gws")
				.and()
				.header("X-XSS-Protection","0")
				.and()
				.header("X-Frame-Options","SAMEORIGIN")
				.and()
				.header("Alt-Svc","h3=\":443\"; ma=2592000,h3-29=\":443\"; ma=2592000")
				.and()
				.header("Transfer-Encoding","chunked")
				.log().all();
	}
	
	@Test(priority=2)
	void GetHeader()
	{
		Response res = given()
		
		.when()
			.get("https://www.google.com/");
		
		// Get Single header Info
		
			//	String header_Value = res.getHeader("Content-Type");
			//	System.out.println("The Value of the Content-Type is====> "+header_Value);
		
		
			// get all header info
		
			Headers myheaders = res.getHeaders();
			for(io.restassured.http.Header hd: myheaders)
			{
				System.out.println(hd.getName()+"          "+hd.getValue());
			}
	}
}
