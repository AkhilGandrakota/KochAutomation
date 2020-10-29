package Pages;

import static org.testng.Assert.*;

/**
 * This class contains all the methods related to flight list page
 *
 * @author gandrakotaakhil@gmail.com
 */
public class FlightListPage extends BasePage {

    /**
     * Verify the flight lis page
     */
    public void verifyFlightListPage() {
        assertTrue(verifyElement("//div[@class=\"flight-listing-page\"]"));
    }

    /**
     * Validate filter option for Stops, departure and Airlines present in flight list page
     */
    public void validateFilterOptions() {
        assertTrue(verifyElement("//div[@class=\"fltr-hdr\" and text()=\"Stops\"]"));
        assertTrue(verifyElement("//div[@class=\"fltr-hdr\" and text()=\"Departure from PNQ\"]"));
        assertTrue(verifyElement("//div[@class=\"fltr-hdr\" and text()=\"Airlines\"]"));
    }

    /**
     * Select Non-Stop in Stops filter option
     */
    public void clickNonStopOption() {
        clickElement("//div[@class=\"stop-info\" and text()=\"Non stop\"]");
    }

    /**
     * Print the list of airlines details (Airline Number, Departure Time and Fare) having fare < maximumPrice
     *
     * @param maximumPrice the maximum price considered for the ticket
     */
    public void printAirlineDetails(int maximumPrice) {
        System.out.println("******* Airline details for flights fare less than "+maximumPrice+" **********");
        int count = getElementCount("//div[@class=\"price\"]");
        for (int i = 1; i <= count; i++) {
            int actualAmount = Integer.valueOf(getElementText("(//div[@class=\"price\"])[" + i + "]/div/span[2]"));
            if (actualAmount < maximumPrice) {
                System.out.println("******* Airline details **********");
                System.out.println("Airline number " + getElementText("(//div[@class=\"price\"])[" + i + "]/parent::div/preceding-sibling::div[@class=\"time-group\"]/div[@class=\"airline-text\"]/div"));
                System.out.println("Departure time " + getElementText("(//div[@class=\"price\"])[" + i + "]/parent::div/preceding-sibling::div[@class=\"time-group\"]/div[@class=\"time\"]"));
                System.out.println("Amount " + actualAmount);
            }
        }
    }
}
