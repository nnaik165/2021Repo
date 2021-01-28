package Drop3defects;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

import java.io.File;
import java.util.Hashtable;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import ReusableCode.auth;
import bloodstream.Suite;
import io.restassured.RestAssured;
import io.restassured.specification.ResponseSpecification;
import utilities.DataHandler;

public class DeleteKeys extends Suite{ 
public static ResponseSpecification responseSpec;	


	
@Test(dataProviderClass = DataHandler.class,dataProvider="dataProvider")
public void Assert200(Hashtable<String,String> dataTable) {
	
	
        File file = new File(System.getProperty("user.dir")+"//payloads//Filter_DeleteKeys.json");
       
        responseSpec = auth.reuseAssert200();
		given().header("Authorization",auth.ValidAuth).body(file).when().post(dataTable.get("EndPoint")).
		then().body("result",is(true)).spec(responseSpec);
	}
}

/*
@Test(dataProviderClass = DataHandler.class,dataProvider="dataProvider")
public void GETAssert200(Hashtable<String,String> dataTable) {
	
	   responseSpec =  auth.reuseAssert200();
		given().header("Authorization",auth.ValidAuth).param("gridName",dataTable.get("gridName")).
	    param("filterName",dataTable.get("filterName")).when().get(dataTable.get("EndPoint")).
		then().body("result",is(true)).spec(responseSpec);
   
}
}
*/