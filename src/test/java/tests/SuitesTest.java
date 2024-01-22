package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class SuitesTest extends BaseTest{

    @Test
    public void sectionShouldBeAdded() {
        loginPage.openPage();
        loginPage.login(user, password);
        dashboardPage.createProject(nameProject);
        dashboardPage.openPage();
        dashboardPage.openProject(nameProject);
        suitesPage.addSection(nameSection);
        assertTrue(suitesPage.findSectionName(nameSection).contains(nameSection), "The section has not been added.");
    }

    @Test
    public void sectionShouldBeEdited() {
        loginPage.openPage();
        loginPage.login(user, password);
        dashboardPage.createProject(nameProject);
        dashboardPage.openPage();
        dashboardPage.openProject(nameProject);
        suitesPage.addSection(nameSection);
        suitesPage.editSection(information);
        assertTrue(suitesPage.findSectionName(information).contains(information),"Section has not been edited successfully.");
    }

    @Test
    public void sectionShouldBeDeleted() {
        loginPage.openPage();
        loginPage.login(user, password);
        dashboardPage.createProject(nameProject);
        dashboardPage.openPage();
        dashboardPage.openProject(nameProject);
        suitesPage.addSection(nameSection);
        suitesPage.deleteSection();
        assertEquals(suitesPage.getMessageSuccessfulDeletedSection(),"No test cases found.","The section has not been deleted.");
    }

    @Test
    public void testCaseShouldBeAdded() {
        loginPage.openPage();
        loginPage.login(user, password);
        dashboardPage.createProject(nameProject);
        dashboardPage.openPage();
        dashboardPage.openProject(nameProject);
        suitesPage.addSection(nameSection);
        suitesPage.addTestCase(nameTestCase);
        assertTrue(suitesPage.getMessageSuccessfulAddedTestCase().contains("Successfully added the new test case."),
                "The test-case has not been added." );
    }

    @Test
    public void testCaseShouldBeEdited() {
        loginPage.openPage();
        loginPage.login(user, password);
        dashboardPage.createProject(nameProject);
        dashboardPage.openPage();
        dashboardPage.openProject(nameProject);
        suitesPage.addSection(nameSection);
        suitesPage.addTestCase(nameTestCase);
        suitesPage.editTestCase(information);
        assertEquals(suitesPage.getMessageSuccessfulEditedTestCase(),
                "Successfully updated the test case.",
                "The test-case has not been edited." );
    }

    @Test
    public void testCaseShouldBeDeleted() {
        loginPage.openPage();
        loginPage.login(user, password);
        dashboardPage.createProject(nameProject);
        dashboardPage.openPage();
        dashboardPage.openProject(nameProject);
        suitesPage.addSection(nameSection);
        suitesPage.addTestCase(nameTestCase);
        suitesPage.deleteTestCase(nameTestCase);
        assertEquals(suitesPage.getMessageSuccessfulDeletedTestCase(),
                "Successfully flagged the test case as deleted.",
                "The test-case has not been deleted." );
    }
}
