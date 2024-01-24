package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

@Log4j2
public class LoginPage extends BasePage {
    private final String EMAIL_CSS = "[data-testid=loginIdName]";
    private final String PASS_CSS = "[data-testid=loginPasswordFormDialog]";
    private final String LOG_IN_BUTTON_CSS = "[data-testid=loginButtonPrimary]";
    private final String ERROR_MESSAGE_CSS = ".loginpage-message";

    public LoginPage openPage() {
        log.info("Opening login page");
        open("auth/login/");
        return this;
    }

    @Step("Log in using credentials: '{user}','{password}'")
    public void login(String user, String password) {
        log.info("Log in using credentials : '{}','{}'",user,password);
        $(EMAIL_CSS).sendKeys(user);
        $(PASS_CSS).sendKeys(password);
        $(LOG_IN_BUTTON_CSS).click();
    }

    public String getErrorMessage() {
        log.info("Getting an error when data is filled in incorrectly");
        return $(ERROR_MESSAGE_CSS).getText();
    }
}
