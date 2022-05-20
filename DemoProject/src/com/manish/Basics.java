package com.manish;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import mni.payload;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;

public class Basics {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//ADD Place POST Method
		RestAssured.baseURI="https://rahulshettyacademy.com";
		String response=given().log().all().queryParam("key", "qaclick123").header("content-type", "application/json")
				.body(payload.Addplace())
				.when().post("/maps/api/place/add/json")
		.then().assertThat().statusCode(200).body("scope", equalTo("APP")).extract().response().asString();
	System.out.println(response);
	JsonPath js=new JsonPath(response);
	String placeID=js.getString("place_id");
	System.out.println("Place ID is:"+placeID);
	
	//Update Place PUT Method
	String newAddress="Summer Walk Africa";
	given().log().all().queryParam("key", "qaclick123").header("content-type", "application/json").body("{\r\n"
			+ "\"place_id\":\""+placeID+" \",\r\n"
			+ "\"address\":\""+newAddress+"\",\r\n"
			+ "\"key\":\"qaclick123\"\r\n"
			+ "}\r\n"
			+ "").when().put("/maps/api/place/update/json").
	then().assertThat().log().all().statusCode(200)
	.body("msg", equalTo("Address successfully updated"));
	
	
	//Get Place
	
	String getPlace=given().log().all().queryParam("key", "qaclick123")
	.queryParam("place_id", placeID)
	.when().get("/maps/api/place/get/json")
	.then().assertThat().log().all().statusCode(200)
	.extract().response().asString();
	
	JsonPath js1=new JsonPath(getPlace);
	String actualAddress=js1.get("address");
	System.out.println("The Actual Address::"+actualAddress);
	Assert.assertEquals(actualAddress, newAddress);
	}

}
