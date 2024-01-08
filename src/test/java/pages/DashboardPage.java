package pages;

import static com.codeborne.selenide.Selenide.$;

public class DashboardPage extends BasePage {
    private final String TITLE_CSS = "[data-testid=testCaseContentHeaderTitle]";
    private final String ADD_PROJECT_BUTTON_CSS ="[data-testid=sidebarProjectsAddButton]";
    private final String PROJECT_NAME_INPUT_CSS ="[data-testid=addProjectNameInput]";
    private final String CREATE_PROJECT_BUTTON_CSS = "[data-testid=addEditProjectAddButton]";

    public String getTitle() {
        return $(TITLE_CSS).getText();
    }

    public void createProject(String name) {
        $(ADD_PROJECT_BUTTON_CSS).click();
        $(PROJECT_NAME_INPUT_CSS).sendKeys(name);
        $(CREATE_PROJECT_BUTTON_CSS).click();
    }
}
