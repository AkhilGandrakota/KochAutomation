package Utils;

import org.openqa.selenium.WebDriver;

public class DriverManager {

    private static WebDriver driver;

    /**
     * This method used to set driver
     *
     * @param driver reference of driver object
     */
    public static void setDriver(WebDriver driver){
        DriverManager.driver = driver;
    }

    /**
     * This method used to get driver
     *
     * @return the driver object
     */
    public static WebDriver getDriver(){
        return DriverManager.driver;
    }
}
