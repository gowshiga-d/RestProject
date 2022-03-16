package RestAssured.RestSample;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class restAssuredDay3 {

	@Test
	public void pojoExample() {
		
		Pojoclass pj = new Pojoclass();
		pj.setAuthor("Author8");
		pj.setTitle("Title8");
		
		//String output = null;
		RestAssured.baseURI = "http://localhost:3000";
		Response res = RestAssured.given().contentType(ContentType.JSON).body(pj).
		when().post("/posts").
		then().statusCode(201).log().all().extract().response();
		
		System.out.println(res);
	}

}
