package MailruTests.Page;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.allure.annotations.Step;

import java.time.Duration;

public class MailViewPage extends BasePage {
    public MailViewPage(WebDriver driver) throws Exception {
        super(driver);
        waitForLoad();
    }

    private final By MAIL_BASE = By.xpath("//div[contains(@class,'letter_expanded')]");
    private final By MAIL_THEME = By.xpath("//h2[@class='thread__subject']");
    private final By MAIL_SENDER = By.xpath("//div[@class='letter__author']/span[@class='letter__contact-item']");
    private final By MAIL_BODY = By.xpath("//div[@class='letter-body']");


    @Step("Ожидание загрузки письма")
    private void waitForLoad() throws Exception {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(driver.findElement(MAIL_BASE)));
        } catch (TimeoutException e) {
            Assert.fail("Письмо не загружено");
        }
    }

    @Step("Проверка письма")
    public void checkMail() {
        try {
            Assert.assertEquals("Неверная тема письма", constants.MAIL_THEME, driver.findElement(MAIL_THEME).getText());
            Assert.assertEquals("Неверный отправитель письма", constants.MAIL_SENDER, driver.findElement(MAIL_SENDER).getText());
            Assert.assertEquals("Неверноя тело письма", constants.MAIL_BODY, driver.findElement(MAIL_BODY).getText());
        } catch (NotFoundException e) {
            Assert.fail("Элемент не найден: " + e);
        }
    }
}
