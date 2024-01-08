package pages;

import static com.codeborne.selenide.Selenide.$;

public class ProjectsPage extends BasePage {
    private final String MESSAGE_SUCCESS_CREATION_PROJECT_CSS = "[data-testid=messageSuccessDivBox]";

    public String getMessageCreationProject() {
        return $(MESSAGE_SUCCESS_CREATION_PROJECT_CSS).getText();
    }
}
