package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;


public class ProjectTest extends BaseTest{

    @Test
    public void projectShouldBeCreated() {
        loginPage.openPage();
        loginPage.login(user,password);
        String nameProject = faker.name().firstName();
        dashboardPage.createProject(nameProject);
        assertEquals(projectPage.getMessageCreationProject(),"Successfully added the new project.","Project not created.");
    }
}
