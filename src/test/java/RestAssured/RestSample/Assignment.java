package RestAssured.RestSample;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

@Test
public class Assignment {

	
	public void restAssignmentUser() {

		JSONObject obj = new JSONObject();
		obj.put("id", 0);
		obj.put("username", "GATEST");
		obj.put("firstname", "test");
		obj.put("lastname", "test");
		obj.put("email", "test@ibm.com");
		obj.put("password", "test");
		obj.put("phone", "9876543210");
		obj.put("userStatus", 0);
		
		String op = obj.toJSONString();
		System.out.println(op);
		
		//Create user
		RestAssured.baseURI = "https://petstore.swagger.io/v2";
		RestAssured.given().contentType(ContentType.JSON).body(obj.toJSONString()).
		when().post("/user").
		then().statusCode(200).log().all();
		
		Object username = obj.get("username");
		System.out.println(obj.get("username"));
		Object password = obj.get("password");
		System.out.println(obj.get("password"));
		
		//Get User details
		RestAssured.given().get("/user/" + username).then().statusCode(200).log().all();
		
		obj.put("phone", "9999999999");
		String updatedop = obj.toJSONString();
		System.out.println(updatedop);
		
		//Update User details
		Response resobj = RestAssured.given().contentType(ContentType.JSON).body(updatedop).
		when().put("/user/" + username).
		then().statusCode(200).log().all().extract().response();
		
		//Login User
		RestAssured.given().queryParam("username", username).queryParam("password", password).
		when().get("/user/login").
		then().statusCode(200).log().all();
		
		//Logout User
		RestAssured.given().get("/user/logout").then().statusCode(200).log().all();
	}
	
	

}
