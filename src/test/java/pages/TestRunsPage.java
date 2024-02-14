package pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.executeJavaScript;

@Log4j2
public class TestRunsPage extends BasePage{

    private final String DELETE_DIALOG_BUTTON_OK_CSS = "[data-testid=caseFieldsTabDeleteDialogButtonOk]";
    private final String TITLE_TEST_RUNS_BUTTON_CSS = "#navigation-runs";
    private final String ADD_TEST_RUNS_BUTTON_CSS = "[data-testid=runAddButton]";
    private final String REFERENCES_INPUT_CSS = "[data-testid=addRunFormRefs]";
    private final String DESCRIPTION_INPUT_CSS = "[data-testid=editSectionDescription]";
    private final String OK_BUTTON_CSS = "[data-testid=addRunFormOkButton]";
    private final String TITLE_WITH_PERCENT_CSS = ".chart-pie-percent-title";
    private final String EDIT_BUTTON_CSS = "[data-testid=runTestEditButton]";
    private final String DESCRIPTION_VIEW_CSS = ".margin_bot";
    private final String DELETE_BUTTON_CSS = "[data-testid=deleteRunButton]";

    @Step("Adding test runs")
    public TestRunsPage addTestRun() {
        log.info("Adding testRuns");
        $(TITLE_TEST_RUNS_BUTTON_CSS).click();
        $(ADD_TEST_RUNS_BUTTON_CSS).click();
        $(REFERENCES_INPUT_CSS).sendKeys("References");
        $(DESCRIPTION_INPUT_CSS).sendKeys("Description");
        $(OK_BUTTON_CSS).click();
        return this;
    }

    @Step("Checking the created test run")
    public void testRunShouldBeCreated() {
        log.info("Checking the created test runs");
        $(TITLE_WITH_PERCENT_CSS).shouldBe(Condition.visible);
    }

    @Step("Edition test run")
    public TestRunsPage editTestRun(String description) {
        log.info("Edition test run");
        $(EDIT_BUTTON_CSS).click();
        $(DESCRIPTION_INPUT_CSS).sendKeys(description + "Update");
        $(OK_BUTTON_CSS).click();
        return this;
    }

    @Step("Checking the edited test run")
    public void testRunShouldBeEdited() {
        log.info("Checking the edited test run");
        $(DESCRIPTION_VIEW_CSS).shouldHave(Condition.text("Update"));
    }

    @Step("Deletion test run")
    public TestRunsPage deleteTestRun() {
        log.info("Deletion test run");
        $(EDIT_BUTTON_CSS).click();
        $(DELETE_BUTTON_CSS).click();
        executeJavaScript("document.getElementsByName('deleteCheckbox')[2].click();");
        $(DELETE_DIALOG_BUTTON_OK_CSS).click();
        return this;
    }

    @Step("Checking the deleted test run")
    public void testRunShouldBeDeleted() {
        log.info("Checking the deleted test run");
        $("[data-testid=planEmptyListTitle]").shouldHave(Condition.text("This project doesn't have any test runs, yet."));
    }
}
