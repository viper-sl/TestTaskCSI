package MailruTests.Page;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.allure.annotations.Step;

import java.time.Duration;
import java.util.List;

public class MailBoxPage extends BasePage {
    public MailBoxPage(WebDriver driver) throws Exception {
        super(driver);
        waitForLoad();
    }

    private final By MAIL_ROW = By.xpath("//div[contains(@class, 'llc__content')]");
    private final By LOADER = By.id("app-loader");

    @Step("Ожидание загрузки почты")
    private void waitForLoad() {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.invisibilityOfElementLocated(LOADER));
            new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(MAIL_ROW));
        } catch (TimeoutException e) {
            Assert.fail("Почта не загрузилась");
        }
    }

    @Step("Открытие письма")
    public void openMail() {
        try {
            List<WebElement> mails = driver.findElements(MAIL_ROW);
            for (WebElement mail : mails) {
                if (mail.getText().contains(constants.MAIL_THEME))
                    mail.click();
            }
        } catch (NotFoundException e) {
            Assert.fail("Элемент не найден: " + e);
        }
    }

}
