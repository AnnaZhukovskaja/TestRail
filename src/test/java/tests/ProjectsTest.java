package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;


public class ProjectsTest extends BaseTest {

    @Test
    public void projectShouldBeCreated() {
        loginPage.openPage();
        loginPage.login(user, password);
        dashboardPage.createProject(nameProject);
        assertEquals(projectPage.getMessageCreationProject(),
                "Successfully added the new project.",
                "The project has not been created.");
    }

    @Test
    public void projectShouldBeEdited() {
        loginPage.openPage();
        loginPage.login(user, password);
        dashboardPage.openProject(dashboardPage.getNameOfFirstProject());
        editProjectPage.editProject(information);
        assertEquals(editProjectPage.geMessageSuccessfulSaving(),
                "Successfully updated the project.",
                "The project has not been changed.");
    }

    @Test
    public void projectShouldBeDeleted() {
        loginPage.openPage();
        loginPage.login(user, password);
        projectPage.openPage();
        projectPage.deleteProject(projectsPage.getNameOfFirstProject());
        assertEquals(projectPage.getMessageDeletionProject(), "Successfully deleted the project.", "The project has not been deleted.");
    }
}
