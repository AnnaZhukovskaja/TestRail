package tests;

import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;
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
        //dashboardPage.createProject(nameProject);
        //dashboardPage.openPage();
        //dashboardPage.openProject(nameProject);
        open("https://nwcompany.testrail.io/index.php?/suites/view/5&group_by=cases:section_id&group_order=asc&display_deleted_cases=0");
        //suitesPage.addSection(nameSection);
        suitesPage.deleteSection("Section 266");
        assertEquals(suitesPage.getMessage(),"No test cases found.","The section has not been deleted.");

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

        assertEquals("",
                "Successfully updated the test cases.",
                "The test-case has not been added." );
    }

    @Test
    public void testCaseShouldBeDeleted() {}

}
