package MailruTests;

import MailruTests.Common.Actions.BrowserStart;
import MailruTests.Common.Constants;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

public class CoreTest {
    public static WebDriver driver;

    @Before
    public  void start() {
        driver = BrowserStart.startChrome(driver);
        Constants.getPropValues();
    }
    @After
    public void exit() {
        driver.quit();
    }
}
