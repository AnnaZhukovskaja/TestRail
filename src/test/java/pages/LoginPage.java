package pages;

import lombok.extern.log4j.Log4j2;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

@Log4j2
public class LoginPage extends BasePage {
    private final String EMAIL_CSS = "[data-testid=loginIdName]";
    private final String PASS_CSS = "[data-testid=loginPasswordFormDialog]";
    private final String LOG_IN_BUTTON_CSS = "[data-testid=loginButtonPrimary]";
    private final String ERROR_MESSAGE_CSS = ".loginpage-message";

    public void openPage() {
        open("auth/login/");
    }

    public void login(String user, String password) {
        $(EMAIL_CSS).sendKeys(user);
        $(PASS_CSS).sendKeys(password);
        $(LOG_IN_BUTTON_CSS).click();
    }

    public String getErrorMessage() {
        return $(ERROR_MESSAGE_CSS).getText();
    }
}
