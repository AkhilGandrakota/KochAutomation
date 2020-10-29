package stepdefs;

import Pages.FlightListPage;
import Pages.TicketDetailsPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class StepDefinition {

    TicketDetailsPage ticketDetailsPage = new TicketDetailsPage();
    FlightListPage flightListPage = new FlightListPage();

    /**
     * Launch the given url
     *
     * @param url the reference of url which needs to be launched
     */
    @Given("^Launch the site \"([^\"]*)\"$")
    public void launchUrl(String url) {
        ticketDetailsPage.launchUrl(url);
    }

    /**
     * Validate the ticket booking page
     */
    @Then("^Verify the booking page$")
    public void verify_the_booking_page() {
        ticketDetailsPage.verifyBookingPage();
    }

    /**
     * Enter From , To , Departure , Return , Travelers
     *
     * @param arg1 from city details
     * @param arg2 to city details
     * @param arg3 departure date
     * @param arg4 return date
     * @param arg5 no of passengers travelling
     */
    @Then("^Enter From – \"([^\"]*)\" , To – \"([^\"]*)\" , Departure – \"([^\"]*)\" , Return – \"([^\"]*)\" , Travelers - \"([^\"]*)\"$")
    public void enter_From_To_Departure_Return_Travelers(String arg1, String arg2, String arg3, String arg4, String arg5) {
        ticketDetailsPage.enterFromDetails(arg1);
        ticketDetailsPage.enterToDetails(arg2);
        ticketDetailsPage.enterDepartureDate(arg3.replaceAll("[^0-9\\,]", ""));
        ticketDetailsPage.enterReturnDate(arg4.replaceAll("[^0-9\\,]", ""));
        ticketDetailsPage.enterNoOfTravellers(arg5);
    }

    /**
     * Click on Search
     */
    @Then("^Click on search button$")
    public void click_on_search_button() {
        ticketDetailsPage.clickSearchButton();
    }

    /**
     * Verify the flight result page
     */
    @Then("^Verify the result page$")
    public void verify_the_result_page() {
        flightListPage.verifyFlightListPage();
    }

    /**
     * Validate filter option for Stops, departure and Airlines – Select Non-Stop in Stops filter option
     */
    @Then("^Validate filter option for Stops, departure and Airlines – Select Non-Stop in Stops filter option$")
    public void validate_filter_option_for_Stops_departure_and_Airlines_Select_Non_Stop_in_Stops_filter_option() {
        flightListPage.validateFilterOptions();
        flightListPage.clickNonStopOption();
    }

    /**
     * Print the list of airlines details (Only Airline Number, Departure Time and Fare) having fare < arg1
     *
     * @param arg1 maximum fare considered for flight
     */
    @Then("^Print the list of airlines details having fare < (\\d+)$")
    public void print_the_list_of_airlines_details_having_fare(int arg1) {
        flightListPage.printAirlineDetails(arg1);
    }
}
