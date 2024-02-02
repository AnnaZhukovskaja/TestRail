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
    private final String USER_NAME_BUTTON_CSS = ".navigation-username";
    private final String LOG_OUT_BUTTON_CSS = "[data-testid=navigationUserLogout]";
    private final String MESSAGE_SUCCESS_LOG_OUT_CSS = ".loginpage-login-text";

    @Step("Opening login page")
    public LoginPage openPage() {
        log.info("Opening login page");
        open(BASE_URL + "auth/login/");
        return this;
    }

    @Step("Log in using credentials: '{user}','{password}'")
    public void login(String user, String password) {
        log.info("Log in using credentials : '{}','{}'",user,password);
        $(EMAIL_CSS).sendKeys(user);
        $(PASS_CSS).sendKeys(password);
        $(LOG_IN_BUTTON_CSS).click();
    }

    @Step("Getting an error when data is filled in incorrectly")
    public String getErrorMessage() {
        log.info("Getting an error when data is filled in incorrectly");
        return $(ERROR_MESSAGE_CSS).getText();
    }

    @Step("Log out")
    public void logOut() {
        log.info("Log out");
        $(USER_NAME_BUTTON_CSS).click();
        $(LOG_OUT_BUTTON_CSS).click();
    }
    @Step("Getting message about success log out")
    public String getMessageSuccess() {
        log.info("Getting message about success log out");
        return $(MESSAGE_SUCCESS_LOG_OUT_CSS).getText();
    }
}
