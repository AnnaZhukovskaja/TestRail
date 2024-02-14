package tests;

import dto.TestCase;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class SuitesTest extends BaseTest{

    @Test (description ="Checking for the creation of a section")
    public void sectionShouldBeAdded() {
        loginPage.
                openPage().
                login(user, password);
        dashboardPage.
                createProject(nameProject);
        dashboardPage.
                openPage().
                openProject(nameProject);
        suitesPage.
                addSection(nameSection).
                sectionShouldExist(nameSection);
    }

    @Test (description = "Checking for changes to the section")
    public void sectionShouldBeEdited() {
        loginPage.
                openPage().
                login(user, password);
        dashboardPage.
                createProject(nameProject);
        dashboardPage.
                openPage().
                openProject(nameProject);
        String newNameSection = nameSection + "Update";
        suitesPage.
                addSection(nameSection).
                editSection(newNameSection).sectionShouldExist(newNameSection);
    }

    @Test (description = "Checking for section deletion")
    public void sectionShouldBeDeleted() {
        loginPage.
                openPage().
                login(user, password);
        dashboardPage.
                createProject(nameProject);
        dashboardPage.
                openPage().
                openProject(nameProject);
        suitesPage.
                addSection(nameSection).
                deleteSection();
        assertEquals(suitesPage.getMessageSuccessfulDeletedSection(),
                "No test cases found.",
                "The section has not been deleted.");
    }

    @Test (description = "Checking for the creation of a test case")
    public void testCaseShouldBeAdded() {
        loginPage.
                openPage().
                login(user, password);
        dashboardPage.
                createProject(nameProject);
        dashboardPage.
                openPage().
                openProject(nameProject);
        TestCase testCase = new TestCase("Title " + faker.number().numberBetween(1, 1000),
                "5m",
                "-",
                "You need to create a project.",
                "Step" + faker.number().numberBetween(1, 1000),
                "The test case has been added.");
        suitesPage.
                addSection(nameSection).
                addTestCase(testCase);
        assertTrue(suitesPage.getMessageSuccessfulResult().contains("Successfully added the new test case."),
                "The test-case has not been added." );
    }

    @Test (description = "Checking for changes to the test case")
    public void testCaseShouldBeEdited() {
        loginPage.
                openPage().
                login(user, password);
        dashboardPage.
                createProject(nameProject);
        dashboardPage.
                openPage().
                openProject(nameProject);
        TestCase testCase = new TestCase("Title " + faker.number().numberBetween(1, 1000),
                "5m",
                "-",
                "You need to create a project.",
                "Step" + faker.number().numberBetween(1, 1000),
                "The test case has been added.");
        suitesPage.
                addSection(nameSection).
                addTestCase(testCase).
                editTestCase(information);
        assertEquals(suitesPage.getMessageSuccessfulResult(),
                "Successfully updated the test case.",
                "The test-case has not been edited." );
    }

    @Test (description = "Checking for test case deletion")
    public void testCaseShouldBeDeleted() {
        loginPage.
                openPage().
                login(user, password);
        dashboardPage.
                createProject(nameProject);
        dashboardPage.
                openPage().
                openProject(nameProject);
        TestCase testCase = new TestCase("Title " + faker.number().numberBetween(1, 1000),
                "5m",
                "-",
                "You need to create a project.",
                "Step" + faker.number().numberBetween(1, 1000),
                "The test case has been added.");
        suitesPage.
                addSection(nameSection).
                addTestCase(testCase).
                deleteTestCase(testCase.getTitle());
        assertEquals(suitesPage.getMessageSuccessfulResult(),
                "Successfully flagged the test case as deleted.",
                "The test-case has not been deleted." );
    }

    @Test(description = "Checking for details in the created test case")
    public void testCaseShouldBeCreatedWithCorrectDetails() {
        loginPage.
                openPage().
                login(user, password);
        dashboardPage.
                createProject(nameProject);
        dashboardPage.
                openPage().
                openProject(nameProject);
        TestCase testCase = new TestCase("Title " + faker.number().numberBetween(1, 1000),
                "5m",
                "-",
                "You need to create a project.",
                "Step" + faker.number().numberBetween(1, 1000),
                "The test case has been added.");
        suitesPage.
                addSection(nameSection).
                addTestCase(testCase).
                testCaseShouldHaveCorrectDetails(testCase);
    }
}
