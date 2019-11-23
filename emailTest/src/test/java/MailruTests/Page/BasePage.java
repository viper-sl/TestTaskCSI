package MailruTests.Page;

import MailruTests.Common.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.allure.annotations.Step;

public abstract class BasePage {

    WebDriver driver;
    Constants constants;

    BasePage(WebDriver driver) {
        this.driver = driver;
        constants = new Constants();
    }

    private final By LOGOUT_BTN = By.id("PH_logoutLink");

    @Step("Открытие страницы {1}")
    static void launchURL(WebDriver driver, String url) {
        driver.get(url);
    }

    @Step("Выход из аккаунта")
    public void logout() {
        try {
            driver.findElement(LOGOUT_BTN).click();

        } catch (
                NotFoundException e) {
            Assert.fail("Элемент не найден: " + e);
        }
    }
}
