package clientCode;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.is;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Hashtable;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ReusableCode.auth;
import bloodstream.Suite;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.ResponseSpecification;
import utilities.DataHandler;
import utilities.config;

public final class getAssays extends Suite{ 
public static ResponseSpecification responseSpec;




@Test
public void TestGet200(Hashtable<String,String> dataTable)
{
	
	//config.log.debug(new Object() {}.getClass().getEnclosingMethod().getName()+ " Invoked");
	
	String Authorization = config.property.getProperty("LoginToken");

	given().
	header("Authorization",Authorization). 
	when().get(dataTable.get("EndPoint")).then().     
	assertThat().statusCode(200);					                        		
}

}



	 
 	