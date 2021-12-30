package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

import org.apache.http.impl.auth.BasicScheme;
import org.junit.Assert;

import commonLibs.CommonLib;

public class StepDefinition {

	RequestSpecification baseURI;
	
	Response  RESP;
	
	
	  @Given("the URI is up and running") public void the_uri_is_up_and_running() {
	  
	  baseURI = given().baseUri("https://api-ssl.bitly.com/v4/");
	  
	  }
	  
	  
	  @When("I do a POST on the URI using the payload for creating new link")
	  public void i_do_a_post_on_the_uri_using_the_payload_for_creating_new_link() {
	    RESP = baseURI.auth().oauth2("8810bc237d326ee962b6b09b6abb705522572c00").header("Content-Type", "application/json").body(CommonLib.payload()).post("bitlinks");
	  }
	  
	  
	  @Then("API returns the result with status code as {int}")
	  public void api_returns_the_result_with_status_code_as(Integer statusCode) {
	     Assert.assertTrue(statusCode == Integer.parseInt(RESP.asString())); 
	  }
	  
	  
	  @Then("new link is created successully.")
	  public void new_link_is_created_successully() {
		  Assert.assertTrue((RESP.asString().contains("SUCCESS")));
	  }
	  
	  
	  @When("I do a Get on the URI using a {string}")
	  public void i_do_a_get_on_the_uri_using_a(String guidNumber) {
	      RESP = baseURI.auth().oauth2("8810bc237d326ee962b6b09b6abb705522572c00").header("Content-Type", "application/json").when().get("groups/" + guidNumber);
	  }
	  
	  
	  @When("I do a Get on the URI using a {string} and sort it using parameter")
	  public void i_do_a_get_on_the_uri_using_a_and_sort_it_using_parameter(String guidNumber) {
	      
		  RESP = baseURI.get("groups/" + guidNumber + "/bitlinks/clicks");
	  }
	  
	  
	  
	 
	 
}
