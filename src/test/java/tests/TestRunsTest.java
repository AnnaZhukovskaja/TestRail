package tests;

import org.testng.annotations.Test;

public class TestRunsTest extends BaseTest{

    @Test(description = "Checking for the creation of a testRuns")
    public void testRunShouldBeAdded() {
        loginPage.
                openPage().
                login(user, password);
        dashboardPage.
                createProject(nameProject);
        dashboardPage.
                openPage().
                openProject(nameProject);
        testRunsPage.
                addTestRun().
                testRunShouldBeCreated();
    }

    @Test(description = "Checking for the edition of a testRuns")
    public void testRunShouldBeEdited() {
        loginPage.
                openPage().
                login(user, password);
        dashboardPage.
                createProject(nameProject);
        dashboardPage.
                openPage().
                openProject(nameProject);
        testRunsPage.
                addTestRun().
                editTestRun(description).
                testRunShouldBeEdited();
    }

    @Test(description = "Checking for the deletion of a testRuns")
    public void testRunShouldBeDeleted() {
        loginPage.
                openPage().
                login(user, password);
        dashboardPage.
                createProject(nameProject);
        dashboardPage.
                openPage().
                openProject(nameProject);
        testRunsPage.
                addTestRun().
                deleteTestRun().
                testRunShouldBeDeleted();
    }
}
