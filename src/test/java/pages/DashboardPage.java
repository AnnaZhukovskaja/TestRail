package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

@Log4j2
public class DashboardPage extends BasePage {
    private final String TITLE_CSS = "[data-testid=testCaseContentHeaderTitle]";
    private final String ADD_PROJECT_BUTTON_CSS = "[data-testid=sidebarProjectsAddButton]";
    private final String PROJECT_NAME_INPUT_CSS = "[data-testid=addProjectNameInput]";
    private final String CREATE_PROJECT_BUTTON_CSS = "[data-testid=addEditProjectAddButton]";
    private final String PROJECT_NAMES_CSS = ".summary-title > a";

    public void openPage() {
        log.info("Opening dashboard page");
        open("dashboard");
    }

    public String getTitle() {
        log.info("Getting the title");
        return $(TITLE_CSS).getText();
    }

    @Step("Creation a project by name: '{name}'")
    public void createProject(String name) {
        log.info("Creation a project by name: '{}'",name);
        $(ADD_PROJECT_BUTTON_CSS).click();
        $(PROJECT_NAME_INPUT_CSS).sendKeys(name);
        $(CREATE_PROJECT_BUTTON_CSS).click();
    }

    @Step("Opening a project by name: '{nameProject}'")
    public void openProject(String nameProject) {
        log.info("Opening project by name: '{}'",nameProject);
        $$(PROJECT_NAMES_CSS).findBy(text(nameProject)).click();
    }

    public String getNameOfFirstProject() {
        log.info("Getting name of first project in the page");
        return $$(PROJECT_NAMES_CSS).first().getText();
    }
}
