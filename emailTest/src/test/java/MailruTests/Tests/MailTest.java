package MailruTests.Tests;

import MailruTests.Page.HomePage;
import MailruTests.Page.MailBoxPage;
import MailruTests.Page.MailViewPage;
import org.junit.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Title;
import MailruTests.CoreTest;

@Title("Тестовый сценарий 'Письмо'")
public class MailTest extends CoreTest {

    @Test
    @Description("Проверка письма")
    public void checkMailTest() throws Exception {
        HomePage homePage = new HomePage(driver);
        homePage.lunch();
        homePage.login();
        MailBoxPage mailBoxPage = new MailBoxPage(driver);
        mailBoxPage.openMail();
        MailViewPage mailViewPage = new MailViewPage(driver);
        mailViewPage.checkMail();
        homePage = new HomePage(driver);
        homePage.logout();
        homePage.checkPage();
    }
}
