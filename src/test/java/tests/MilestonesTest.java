package tests;

import dto.Milestone;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class MilestonesTest extends BaseTest {

    @Test(description = "Verification of creation a milestone")
    public void milestoneShouldBeCreated() {
        loginPage.openPage().login(user, password);
        dashboardPage.createProject(nameProject);
        dashboardPage.openPage().openProject(nameProject);
        Milestone milestone = Milestone.builder().
                name("Sprint " + faker.number().numberBetween(1, 100)).
                references(faker.address().toString()).
                description(faker.lorem().toString()).build();
        milestonePage.createMilestone(milestone).sectionShouldExist(milestone.getName());
    }

    @Test(description = "Verification of creation a milestone")
    public void milestoneShouldBeDeleted() {
        loginPage.openPage().login(user, password);
        dashboardPage.createProject(nameProject);
        dashboardPage.openPage().openProject(nameProject);
        Milestone milestone = Milestone.builder().
                name("Sprint " + faker.number().numberBetween(1, 100)).
                references(faker.address().toString()).
                description(faker.lorem().toString()).build();
        milestonePage.createMilestone(milestone).deleteMilestone(milestone.getName());
        assertEquals(milestonePage.getMessageSuccess(),
                "Successfully deleted the milestone.",
                "Milestone has not been deleted.");
    }

    @Test(description = "Verification of creation a milestone")
    public void milestoneShouldBeEdited() {
        loginPage.openPage().login(user, password);
        dashboardPage.createProject(nameProject);
        dashboardPage.openPage().openProject(nameProject);
        Milestone milestone = Milestone.builder().
                name("Sprint " + faker.number().numberBetween(1, 100)).
                references(faker.address().toString()).
                description(faker.lorem().toString()).build();
        milestonePage.createMilestone(milestone);
        milestonePage.editMilestone(milestone.getName(),information);
        assertEquals(milestonePage.getMessageSuccess(),
                "Successfully updated the milestone.",
                "Milestone has not been deleted.");
    }
}