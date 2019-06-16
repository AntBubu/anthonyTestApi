package weatherforecast.stepdefinitions;

import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import net.serenitybdd.rest.Ensure;
import net.serenitybdd.rest.SerenityRest;
import java.time.LocalDate;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.equalTo;


public class WeatherCheckStepDefinitions {



    @Before
    public void setupBaseUrl(){
        RestAssured.baseURI ="https://www.metaweather.com/api/";}



    @When("Iris calls an API location with a woeid (.*) for (.*) to check the weather")
    public void she_calls_an_API_location_with_a_woeid_for_a_city_to_check_the_weather(String woeid, String city) {
        SerenityRest.given().when().get("/location/{woeid}", woeid)
                .then().statusCode(200);

        Ensure.that("the correct location is displayed", response -> response.body("title", equalTo(city)));

    }


    @Then("she should see if the forecast for today is (.*)")
    public void she_Should_See_If_The_Forecast_For_Today_Is_(String weather) {

        // I wanted to check that the date returned as part of the query was the correct one in case the API changed somewhat.
        LocalDate today = LocalDate.now();

        String weatherForecast = SerenityRest.lastResponse().jsonPath().getString("consolidated_weather[0].weather_state_name");
        String apiDate = SerenityRest.lastResponse().jsonPath().getString("consolidated_weather[0].applicable_date");

        assertThat(apiDate).isEqualTo(today.toString());
        assertThat(weatherForecast).isEqualTo(weather);

    }

    @Then("she should see if the forecast for tomorrow is (.*)")
    public void she_Should_See_If_The_Forecast_For_Tomorrow_Is(String weather) {
       LocalDate today = LocalDate.now();
       LocalDate tomorrow = today.plusDays(1);

        String weatherForecast = SerenityRest.lastResponse().jsonPath().getString("consolidated_weather[1].weather_state_name");
        String apiDate = SerenityRest.lastResponse().jsonPath().getString("consolidated_weather[1].applicable_date");

        assertThat(apiDate).isEqualTo(tomorrow.toString());
        assertThat(weatherForecast).isEqualTo(weather);

    }


    @Then("she should see if the forecast for the day after tomorrow is (.*)")
    public void she_Should_See_If_The_Forecast_For_The_Day_After_Tomorrow_Is(String weather) {
        LocalDate today = LocalDate.now();
        LocalDate dayAfterTomorrow = today.plusDays(2);

        String weatherForecast = SerenityRest.lastResponse().jsonPath().getString("consolidated_weather[2].weather_state_name");
        String apiDate = SerenityRest.lastResponse().jsonPath().getString("consolidated_weather[2].applicable_date");

        assertThat(apiDate).isEqualTo(dayAfterTomorrow.toString());
        assertThat(weatherForecast).isEqualTo(weather);
    }

    @Then("she should see if the forecast in three days time is (.*)")
    public void she_Should_See_If_The_Forecast_In_Three_Days_Time_Is(String weather) {
        LocalDate today = LocalDate.now();
        LocalDate futureDate = today.plusDays(3);

        String weatherForecast = SerenityRest.lastResponse().jsonPath().getString("consolidated_weather[3].weather_state_name");
        String apiDate = SerenityRest.lastResponse().jsonPath().getString("consolidated_weather[3].applicable_date");

        assertThat(apiDate).isEqualTo(futureDate.toString());
        assertThat(weatherForecast).isEqualTo(weather);
    }
}
