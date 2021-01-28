package searchFilter;

import static io.restassured.RestAssured.given;
import java.io.File;
import java.util.Hashtable;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ReusableCode.auth;
import bloodstream.Suite;
import io.restassured.RestAssured;
import io.restassured.specification.ResponseSpecification;
import utilities.DataHandler;

public class SearchFilter_POSTWorklistConc extends Suite{ 
public static ResponseSpecification responseSpec;	

  
@Test(dataProviderClass = DataHandler.class,dataProvider="dataProvider")
public void Assert200(Hashtable<String,String> dataTable) {
	
	    auth.reuseAssert200();
        File file = new File(System.getProperty("user.dir")+"//payloads//postSearchFilterWorklistConclusion200.json");
     	given().header("Authorization",auth.ValidAuth).body(file).when().post(dataTable.get("EndPoint")).then().spec(responseSpec); 
     	
}

@Test(dataProviderClass = DataHandler.class,dataProvider="dataProvider")
public void Assert400(Hashtable<String,String> dataTable)
{
	    auth.reuseAssert400();
	    File file = new File(System.getProperty("user.dir")+"//payloads//postSearchFilterWorklistConclusion400.json");
		given().header("Authorization",auth.ValidAuth).body(file).when().post(dataTable.get("EndPoint")).then().spec(responseSpec); 
	     
}


@Test(dataProviderClass = DataHandler.class,dataProvider="dataProvider")
public void Assert401(Hashtable<String,String> dataTable)
{
	    auth.reuseAssert401();
	    given().header("Authorization",auth.InvalidAuth).when().post(dataTable.get("EndPoint")).then().spec(responseSpec); 
		
}
}
