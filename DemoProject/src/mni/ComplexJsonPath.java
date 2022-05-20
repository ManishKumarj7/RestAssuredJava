package mni;

import io.restassured.path.json.JsonPath;

public class ComplexJsonPath {
public static void main(String[]args) {
	
	int sum=0;
	JsonPath js=new JsonPath(payload.CoursePrice());
	//Print No of courses returned by API
	System.out.println("\n\nQ1:Print No of courses returned by API");
	int count =js.getInt("courses.size()");
	System.out.println("Ans:"+count);
	
	//Print Purchase Amount
	System.out.println("\n\nQ2:Print Purchase Amount");
	int totalAmount=js.getInt("dashboard.purchaseAmount");
	System.out.println("Total Amount:"+totalAmount);
	
	//Print Title of the first course
	System.out.println("\n\nQ3:Print Title of the first course");
	String mni=js.getString("courses[2].title");
	System.out.println("Title at 2 index:"+mni);
	
	//Print All course titles and their respective Prices
	System.out.println("\n\nQ4:course titles and their respective Prices");
	for(int i=0;i<count;i++) {
		String coursesTitle=js.get("courses["+i+"].title");
		int coursesPrice= js.get("courses["+i+"].price"); 
		int totalCopies=js.getInt("courses["+i+"].copies");//getting Sum of all Course prices matches with Purchase Amount or not
		 sum=sum+(coursesPrice * totalCopies );
		
		System.out.println(coursesTitle +" "+coursesPrice );
		//System.out.println(js.get("courses["+i+"].price").toString());
	}
	 
	
	//Print no of copies sold by RPA Course
	System.out.println("\n\n Q5:Print no of copies sold by RPA Course");
	for(int i=0;i<count;i++) {
		String courseTitles=js.get("courses["+i+"].title");
	if(courseTitles.equalsIgnoreCase("RPA")) {
		int copies=js.get("courses["+i+"].copies");
		System.out.println("Number Of Sold copies of RPA:"+copies);
	}
	}
	System.out.println("\n\nSum:"+sum);
	
	int tPurchaseAmount=js.getInt("dashboard.purchaseAmount");
	System.out.println("PurchaseAmount:"+tPurchaseAmount);
	if(sum==tPurchaseAmount) {
		System.out.println("Sum of all Course prices matches with Purchase Amount");
		
	}else {
		System.out.println("Sum of all Course prices is not matching with Purchase Amount");
	}
}
}
