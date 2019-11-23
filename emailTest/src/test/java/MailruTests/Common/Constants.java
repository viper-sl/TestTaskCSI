package MailruTests.Common;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

public class Constants {

    private static FileInputStream fis;
    private static Properties property = new Properties();

    public static void getPropValues() {
        try {
            fis = new FileInputStream("src/test/resources/PropertyFiles/env.properties");
            property.load(new InputStreamReader(fis, StandardCharsets.UTF_8));
        } catch (IOException e) {
            System.err.println("No prop file found");
        }
    }

    public final String BASE_PAGE = property.getProperty("base.page");
    public final String USER_LOGIN = property.getProperty("user.login");
    public final String USER_DOM = property.getProperty("user.host");
    public final String USER_PASS = property.getProperty("user.pass");
    public final String MAIL_THEME = "Тема письма";
    public final String MAIL_BODY = "Тело письма";
    public final String MAIL_SENDER = "Слава Лопарев";
}
