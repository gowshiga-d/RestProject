package RestAssured.RestSample;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class restAssuredDay2 {


	public void jsonObjectExample() {
		
		JSONObject obj = new JSONObject();
		obj.put("id", 7);
		obj.put("title", "Title7");
		obj.put("author", "author7");
		
		String output = obj.toJSONString();
		System.out.println(output);
		
		RestAssured.baseURI = "http://localhost:3000";
		Response responseObject = RestAssured.given().contentType(ContentType.JSON).body(output).
		when().post("/posts").
		then().statusCode(201).log().all().extract().response();
		
		String author = responseObject.jsonPath().getString("author");
		Assert.assertEquals(author, "author7");
		String title = responseObject.jsonPath().getString("title");
		System.out.println(title);
	
		//RestAssured.given().get("/posts/5").then().statusCode(200).log().all().extract().response();
	}
	


}
