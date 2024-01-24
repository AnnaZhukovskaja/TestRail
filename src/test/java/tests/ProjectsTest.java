package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;


public class ProjectsTest extends BaseTest {

    @Test (retryAnalyzer = Retry.class,description = "Сhecking for the creation of a project")
    public void projectShouldBeCreated() {
        loginPage.openPage().login(user, password);
        dashboardPage.createProject(nameProject);
        assertEquals(projectPage.getMessageCreationProject(),
                "Successfully added the new project.",
                "The project has not been created.");
    }

    @Test (retryAnalyzer = Retry.class,description = "Сhecking for changes to the project")
    public void projectShouldBeEdited() {
        loginPage.openPage().login(user, password);
        dashboardPage.openProject(dashboardPage.getNameOfFirstProject());
        editProjectPage.editProject(information);
        assertEquals(editProjectPage.geMessageSuccessfulSaving(),
                "Successfully updated the project.",
                "The project has not been changed.");
    }

    @Test (retryAnalyzer = Retry.class,description = "Checking for project deletion")
    public void projectShouldBeDeleted() {
        loginPage.openPage().login(user, password);
        projectPage.openPage().deleteProject(projectsPage.getNameOfFirstProject());
        assertEquals(projectPage.getMessageDeletionProject(), "Successfully deleted the project.", "The project has not been deleted.");
    }
}
