import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * This class sets up the driver
 *
 * @author gandrakotaakhil@gmail.com
 */
public class SetupClass {

  /**
   * This methods will create the chrome driver by reading all the capabilities
   *
   * */
  public static WebDriver createDriver() {
        WebDriverManager.chromedriver().setup();
      WebDriver driver = new ChromeDriver();
      return driver;
    }
}
