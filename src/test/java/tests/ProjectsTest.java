package tests;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ProjectsTest extends BaseTest {

    @Test (description = "Checking for the creation of a project")
    public void projectShouldBeCreated() {
        loginPage.
                openPage().
                login(user, password);
        dashboardPage.
                createProject(nameProject);
        assertEquals(projectPage.getMessageSuccessfulResult(),
                "Successfully added the new project.",
                "The project has not been created.");
    }

    @Test (description = "Checking for changes to the project")
    public void projectShouldBeEdited() {
        loginPage.
                openPage().
                login(user, password);
        dashboardPage.
                createProject(nameProject);
        projectsPage.
                openProject(nameProject).
                editProject("https://nwcompany.testrail.io/index.php?/admin/projects/edit/394");
        assertEquals(projectPage.getMessageSuccessfulResult(),
                "Successfully updated the project.",
                "The project has not been changed.");
    }

    @Test (description = "Checking for project deletion")
    public void projectShouldBeDeleted() {
        loginPage.
                openPage().
                login(user, password);
        dashboardPage.
                createProject(nameProject);
        projectsPage.
                deleteProject(nameProject);
        assertEquals(projectPage.getMessageSuccessfulResult(),
                "Successfully deleted the project.",
                "The project has not been deleted.");
    }
}
