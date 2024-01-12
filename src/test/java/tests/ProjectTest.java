package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;


public class ProjectTest extends BaseTest{

    @Test
    public void projectShouldBeCreated() {
        loginPage.openPage();
        loginPage.login(user,password);
        dashboardPage.createProject(nameProject);
        assertEquals(projectPage.getMessageCreationProject(),"Successfully added the new project.","Project not created.");
    }

    @Test
    public void projectShouldBeEdited() {
        loginPage.openPage();
        loginPage.login(user,password);
        dashboardPage.openProject("Ashlyn");
        editProjectPage.editProject(information);
        assertEquals(editProjectPage.geMessageSuccessfulSaving(),"Successfully updated the project." ,"The project has not been changed.");
    }
}
