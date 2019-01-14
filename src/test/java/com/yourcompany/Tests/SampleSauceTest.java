import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.By;
import org.junit.*;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import java.net.URL;

public class SampleSauceTest {

  public static final String USERNAME = System.getenv("SAUCE_USERNAME");
  public static final String ACCESS_KEY = System.getenv("SAUCE_ACCESS_KEY");
  public AppiumDriver driver;

  @Before
  public void setUp() throws Exception {

    URL US_endpoint = new URL("https://eu1.appium.testobject.com/wd/hub");
    DesiredCapabilities caps = new DesiredCapabilities();
    caps.setCapability("testobject_api_key", "61A40172E8CD4D87BE786EB6586A82C1");
    caps.setCapability("platformVersion", "7"); // Optional
		caps.setCapability("deviceName", "Samsung Galaxy Tab S2"); // Optional

    driver = new AndroidDriver(US_endpoint , caps);
  }

  @Test
  public void testMethod() {

    WebElement seven = driver.findElement(By.id("digit7"));
    WebElement three = driver.findElement(By.id("digit3"));
    WebElement plus = driver.findElementByAccessibilityId("plus");
    WebElement equals = driver.findElementByAccessibilityId("equals");
    WebElement display = (MobileElement) driver.findElementByClassName("android.widget.EditText");



    seven.click();
    plus.click();
    three.click();
    equals.click();


    assertThat(display.getText(), containsString("10"));
  }

  @After
  public void tearDown() {
    driver.quit();
  }
}
