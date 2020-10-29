package Pages;

import static org.testng.Assert.*;

/**
 * This class contains all the methods related to Ticket details page
 *
 * @author gandrakotaakhil@gmail.com
 */
public class TicketDetailsPage extends BasePage {
    /**
     * Launch the given url
     *
     * @param url the reference of url which needs to be launched
     */
    public void launchUrl(String url) {
        get(url);
    }

    /**
     * Validate the ticket booking page
     */
    public void verifyBookingPage() {
        assertTrue(verifyElement("//img[@class=\"ixigo-logo\"]"));
    }

    /**
     * Enter from city details of the aeroplane
     *
     * @param fromCity contains the reference of from city
     */
    public void enterFromDetails(String fromCity) {
        sendKeysElement("//div[text()=\"From\"]/following-sibling::input", fromCity);
        clickElement("//div[contains(text(),\"" + fromCity + "\")]");
    }

    /**
     * Enter to city details of the aeroplane
     *
     * @param toCity contains the reference of to city
     */
    public void enterToDetails(String toCity) {
        sendKeysElement("//div[text()=\"To\"]/following-sibling::input", toCity);
        clickElement("//div[contains(text(),\"" + toCity + "\")]");
    }

    /**
     * Enter the flight departure date
     *
     * @param departureDate
     */
    public void enterDepartureDate(String departureDate) {
        clickElement("//div[text()=\"Departure\"]/following-sibling::input");
        clickElement("(//div[@class=\"rd-month-label\" and text()=\"November 2020\"])[1]/following-sibling::table/tbody/tr/td[@data-date=\"" + departureDate + "\"]/div");
    }

    /**
     * Enter the flight return date
     *
     * @param returnDate
     */
    public void enterReturnDate(String returnDate) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        clickElement("//div[text()=\"Return\"]/following-sibling::input");
        clickElement("(//div[@class=\"rd-month-label\" and text()=\"November 2020\"])[2]/following-sibling::table/tbody/tr/td[@data-date=\"" + returnDate + "\"]");
    }

    /**
     * Enter the number of passenger details
     *
     * @param noOfTravallers
     */
    public void enterNoOfTravellers(String noOfTravallers) {
        clickElement("//div[text()=\"Travellers | Class\"]/following-sibling::input");
        clickElement("//div[text()=\"Adult\"]/../../div[2]/span[@data-val=\"" + noOfTravallers + "\"]");
    }

    /**
     * Click on Search
     */
    public void clickSearchButton() {
        clickElement("//button[text()=\"Search\"]");
    }


}
