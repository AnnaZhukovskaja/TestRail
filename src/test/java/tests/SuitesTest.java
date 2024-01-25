package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class SuitesTest extends BaseTest{

    @Test (retryAnalyzer = Retry.class,description = "Сhecking for the creation of a section")
    public void sectionShouldBeAdded() {
        loginPage.openPage().login(user, password);
        dashboardPage.createProject(nameProject);
        dashboardPage.openPage().openProject(nameProject);
        suitesPage.addSection(nameSection);
        assertTrue(suitesPage.findSectionName(nameSection).contains(nameSection), "The section has not been added.");
    }

    @Test (retryAnalyzer = Retry.class,description = "Сhecking for changes to the section")
    public void sectionShouldBeEdited() {
        loginPage.openPage().login(user, password);
        dashboardPage.createProject(nameProject);
        dashboardPage.openPage().openProject(nameProject);
        suitesPage.addSection(nameSection).editSection(information);
        assertTrue(suitesPage.findSectionName(information).contains(information),"Section has not been edited successfully.");
    }

    @Test (retryAnalyzer = Retry.class, description = "Checking for section deletion")
    public void sectionShouldBeDeleted() {
        loginPage.openPage().login(user, password);
        dashboardPage.createProject(nameProject);
        dashboardPage.openPage().openProject(nameProject);
        suitesPage.addSection(nameSection).deleteSection();
        assertEquals(suitesPage.getMessageSuccessfulDeletedSection(),"No test cases found.","The section has not been deleted.");
    }

    @Test (retryAnalyzer = Retry.class, description = "Сhecking for the creation of a test case")
    public void testCaseShouldBeAdded() {
        loginPage.openPage().login(user, password);
        dashboardPage.createProject(nameProject);
        dashboardPage.openPage().openProject(nameProject);
        suitesPage.addSection(nameSection).addTestCase(nameTestCase);
        assertTrue(suitesPage.getMessageSuccessfulAddedTestCase().contains("Successfully added the new test case."),
                "The test-case has not been added." );
    }

    @Test (retryAnalyzer = Retry.class, description = "Сhecking for changes to the test case")
    public void testCaseShouldBeEdited() {
        loginPage.openPage().login(user, password);
        dashboardPage.createProject(nameProject);
        dashboardPage.openPage().openProject(nameProject);
        suitesPage.addSection(nameSection).addTestCase(nameTestCase);
        suitesPage.editTestCase(information);
        assertEquals(suitesPage.getMessageSuccessfulEditedTestCase(),
                "Successfully updated the test case.",
                "The test-case has not been edited." );
    }

    @Test (retryAnalyzer = Retry.class, description = "Checking for test case deletion")
    public void testCaseShouldBeDeleted() {
        loginPage.openPage().login(user, password);
        dashboardPage.createProject(nameProject);
        dashboardPage.openPage().openProject(nameProject);
        suitesPage.addSection(nameSection).addTestCase(nameTestCase);
        suitesPage.deleteTestCase(nameTestCase);
        assertEquals(suitesPage.getMessageSuccessfulDeletedTestCase(),
                "Successfully flagged the test case as deleted.",
                "The test-case has not been deleted." );
    }
}
