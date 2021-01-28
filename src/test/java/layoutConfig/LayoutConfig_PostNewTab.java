package layoutConfig;

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

public class LayoutConfig_PostNewTab extends Suite{ 
public static ResponseSpecification responseSpec;	

	
	@Test(dataProviderClass = DataHandler.class,dataProvider="dataProvider")
	public void Assert200(Hashtable<String,String> dataTable) {
		
		responseSpec = auth.reuseAssert200();
		File file = new File(System.getProperty("user.dir")+"//payloads//postNewTab200.json");
	    given().header("Authorization",auth.ValidAuth).body(file).when().post(dataTable.get("EndPoint")).
	    then().body("result",is(true)).spec(responseSpec); 
	  }
	
	 @Test(dataProviderClass = DataHandler.class,dataProvider="dataProvider")
     public void Assert400(Hashtable<String,String> dataTable) {
		
		 responseSpec = auth.reuseAssert400();
		 File file = new File(System.getProperty("user.dir")+"//payloads//postNewTab400.json");
		 given().header("Authorization",auth.ValidAuth).body(file).when().post(dataTable.get("EndPoint")).
		 then().body("result",is(false)).spec(responseSpec); 
	}
	 
	@Test(dataProviderClass = DataHandler.class,dataProvider="dataProvider")
    public void Assert401(Hashtable<String,String> dataTable) {
		
		 responseSpec = auth.reuseAssert401();
		 given().header("Authorization",auth.InvalidAuth).when().post(dataTable.get("EndPoint")).
		 then().spec(responseSpec);  
	}
	
}




