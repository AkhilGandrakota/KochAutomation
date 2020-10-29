package Pages;

import Utils.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This class contains all the library methods which are necessary for execution
 *
 * @author gandrakotaakhil@gmail.com
 */
public class BasePage {

    public static final int DEFAULT_TIMEOUT = 20;


    /**
     * This method is used to launch the url
     *
     * @param url contains the reference od url to be launched
     */
    public void get(String url) {
        System.out.println("Launching url " + url);
        DriverManager.getDriver().get(url);
    }

    /**
     * This method will verify whether the element is present on the screen
     *
     * @param locatorKey contains the reference of locator key
     * @return the status of verification
     */
    public Boolean verifyElement(String locatorKey) {
        try {
            WebElement element = new WebDriverWait(DriverManager.getDriver(), DEFAULT_TIMEOUT).until(ExpectedConditions.presenceOfElementLocated(By.xpath(locatorKey)));
            System.out.println("Successfully found element " + locatorKey);
            return true;
        } catch (Exception ex) {
            System.out.println("Error in finding " + locatorKey);
            return false;
        }
    }

    /**
     * This method will perform click operation on given element
     *
     * @param locatorKey contains the reference of locator key
     */
    public void clickElement(String locatorKey) {
        System.out.println("Performing click on element " + locatorKey);
        WebElement element = new WebDriverWait(DriverManager.getDriver(), DEFAULT_TIMEOUT).until(ExpectedConditions.presenceOfElementLocated(By.xpath(locatorKey)));
        element.click();
    }

    /**
     * This method will perform the send keys operation on given element
     *
     * @param locatorKey contains the reference of locator key
     * @param text       the reference of text to be sent
     */
    public void sendKeysElement(String locatorKey, String text) {
        System.out.println("Performing send keys on element " + locatorKey);
        WebElement element = new WebDriverWait(DriverManager.getDriver(), DEFAULT_TIMEOUT).until(ExpectedConditions.presenceOfElementLocated(By.xpath(locatorKey)));
        element.sendKeys(text);
    }

    /**
     * The the count of elements present on the screen
     *
     * @param locatorKey contains the reference of locator key
     * @return The value of element count
     */
    public int getElementCount(String locatorKey) {
        System.out.println("Getting size of element " + locatorKey);
        WebElement element = new WebDriverWait(DriverManager.getDriver(), DEFAULT_TIMEOUT).until(ExpectedConditions.presenceOfElementLocated(By.xpath(locatorKey)));
        int noOfElements = DriverManager.getDriver().findElements(By.xpath(locatorKey)).size();
        return noOfElements;
    }

    /**
     * This method will get the text of element
     *
     * @param locatorKey contains the reference of locator key
     * @return the text of element
     */
    public String getElementText(String locatorKey) {
        //System.out.println("Getting text of element " + locatorKey);
        WebElement element = new WebDriverWait(DriverManager.getDriver(), DEFAULT_TIMEOUT).until(ExpectedConditions.presenceOfElementLocated(By.xpath(locatorKey)));
        return DriverManager.getDriver().findElement(By.xpath(locatorKey)).getText();
    }
}
