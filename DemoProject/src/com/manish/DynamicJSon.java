package com.manish;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import mni.payload;

import static io.restassured.RestAssured.*;

public class DynamicJSon {


	@Test(dataProvider="Bookdata")
	public void AddBook(String isbn,String aisle) {
		RestAssured.baseURI="http://216.10.245.166";
		@SuppressWarnings("unused")
		String response=given().log().all()
				.header("content-type","application/json")
				.body(payload.Addbook(isbn, aisle)).when().post("/Library/Addbook.php").
				then().log().all().assertThat().statusCode(200).extract().response().asString();
		System.out.println(response);
		JsonPath js=new JsonPath(response);
		String id=js.getString("ID");
		System.out.println("ID is:"+id);
	}
@DataProvider(name="Bookdata")
public Object[][] getData() {
	
	return new Object[][] {{"ojfty","22311"},{"aadwe","57535"},{"chdfb","12246"}};
}
}
