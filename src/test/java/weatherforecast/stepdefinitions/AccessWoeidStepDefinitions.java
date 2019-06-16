package weatherforecast.stepdefinitions;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import net.serenitybdd.rest.Ensure;
import net.serenitybdd.rest.SerenityRest;
import static org.hamcrest.Matchers.equalTo;

public class AccessWoeidStepDefinitions {

// using rest assured to set up my base url for all subsequent requests
    @Before
    public void setupBaseUrl(){
        RestAssured.baseURI ="https://www.metaweather.com/api/";}


    @Given("the API is up and running")
    public void the_API_is_up_and_running() {
        SerenityRest.when().get()
                .then().statusCode(200);
    }

    @When("(.*) searches for (.*) woeid")
    public void searches_for_a_city_woeid(String user, String city) {
        SerenityRest.given().queryParam("query",city)
                .when().get("/location/search")
                .then().statusCode(200);

        // the Ensure.that method adds an extra step with a helpful message in the reporting, it's a nice to have.
        Ensure.that("the correct location is displayed", response -> response.body("[0].title", equalTo(city)));
    }

    @Then("she should be able to retrieve it to access another location for (.*)")
    public void she_should_be_able_to_use_to_access_another_location(String city) {

        String apiWoeid = SerenityRest.lastResponse().jsonPath().getString("[0].woeid");

/* the given().when() might seem strange but it is actually needed as the given functionality resets the previous given, otherwise
         it would have assumed that the one beforehand is still valid. This could link
         to java.lang.IllegalArgumentException: Invalid number of path parameters. Expected 0, was 1. Redundant path parameters are:.
         or the query looking like https://www.metaweather.com/api/location/44418/?query=london */

        SerenityRest.given().when().get("/location/{woeid}", apiWoeid)
              .then().statusCode(200);

        Ensure.that("the correct location is displayed", response -> response.body("title", equalTo(city)));

    }

}
