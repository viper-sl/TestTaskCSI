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

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void lunch() {
        launchURL(driver, constants.BASE_PAGE);
    }

    private final By LOGIN_INPUT = By.id("mailbox:login");
    private final By PASS_BTN = By.xpath("//input[@value='Ввести пароль']");
    private final By PASS_INPUT = By.id("mailbox:password");
    private final By LOGIN_BTN = By.id("mailbox:submit");
    private final By HEAD_LOGIN_BTN = By.id("PH_authLink");

    @Step("Вход в аккаунт")
    public void login() {
        try {
            driver.findElement(LOGIN_INPUT).sendKeys(constants.USER_LOGIN);
            driver.findElement(PASS_BTN).click();
            try {
                new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(driver.findElement(PASS_INPUT)));
            } catch (TimeoutException e) {
                Assert.fail("Поле ввода пароля не появилось");
            }
            driver.findElement(PASS_INPUT).sendKeys(constants.USER_PASS);
            driver.findElement(LOGIN_BTN).click();
        } catch (NotFoundException e) {
            Assert.fail("Элемент не найден: " + e);
        }
    }

    @Step("Проверка страницы")
    public void checkPage() {
        try {
            Assert.assertTrue("Кнопка войти не отображается", driver.findElement(HEAD_LOGIN_BTN).isDisplayed());
        } catch (NotFoundException e) {
            Assert.fail("Элемент не найден: " + e);
        }
    }
}
