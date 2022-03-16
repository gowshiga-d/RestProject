package RestAssured.RestSample;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class restAssuredDay1 {

	public void methodRes() {

		Response res = RestAssured.get("http://localhost:3000/comments");
		String responseBody = res.asString();
		System.out.println(responseBody); // prints response body
		System.out.println(res.getStatusCode());// prints Statuscode
		System.out.println(res.getStatusLine());// prints Statusline
		System.out.println(res.getHeaders());// prints headers
		System.out.println(res.jsonPath().getString("postId"));// prints values in json
	}

	@Test(enabled=false)
	public void getDelete() {

		RestAssured.baseURI = "http://localhost:3000";
		// get
		RestAssured.given().get("/comments/1").then().statusCode(200).log().all();
		// delete
		// RestAssured.given().delete("/comments/1").then().statusCode(200).log().all();

	}

	@Test
	public void queryParam() {
		
		RestAssured.baseURI = "https://reqres.in";
		RestAssured.given().contentType(ContentType.JSON).queryParam("page", "2").when().get("/api/users")
				.then().statusCode(200).log().all();

	}
}
