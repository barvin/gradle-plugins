package com.example.tests;

import com.example.annotations.TestCase;
import com.example.entities.Reminder;
import com.example.groups.Groups;
import com.example.groups.Sprints;
import com.example.groups.Teams;
import com.example.steps.ui.CommonUiSteps;
import com.example.steps.ui.NavigationSteps;
import com.example.steps.ui.ReminderSteps;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.OffsetDateTime;

public class RemindersTest {

    @DataProvider
    public Object[][] createReminderData() {
        Reminder reminder = new Reminder();
        reminder.setText("Buy flowers");
        reminder.setTime(OffsetDateTime.now().plusDays(1));
        return new Object[][]{new Object[]{reminder}};
    }

    @Test(description = "Create reminder",
            dataProvider = "createReminderData",
            groups = {Groups.SMOKE, Teams.ALPHA, Sprints._1})
    @TestCase("REM-132")
    public void createReminder(Reminder reminder) {
        NavigationSteps.openRemindersApp();
        ReminderSteps.addReminder(reminder);
        ReminderSteps.checkLastReminder(reminder);
    }

    @DataProvider
    public Object[][] updateReminderData() {
        Reminder oldReminder = new Reminder();
        oldReminder.setText("Old text");
        oldReminder.setTime(OffsetDateTime.now().plusDays(2));
        Reminder newReminder = new Reminder();
        newReminder.setText("New text");
        newReminder.setTime(OffsetDateTime.now().plusDays(3));
        return new Object[][]{new Object[]{oldReminder, newReminder}};
    }

    @Test(description = "Update reminder",
            dataProvider = "updateReminderData",
            groups = {Teams.BETA, Sprints._1})
    @TestCase("REM-157")
    public void updateReminder(Reminder oldReminder, Reminder newReminder) {
        NavigationSteps.openRemindersApp();
        ReminderSteps.addReminder(oldReminder);
        ReminderSteps.updateLastReminder(newReminder);
        CommonUiSteps.refreshPage();
        ReminderSteps.checkLastReminder(newReminder);
    }

    @DataProvider
    public Object[][] deleteReminderData() {
        Reminder reminder = new Reminder();
        reminder.setText("Delete me");
        reminder.setTime(OffsetDateTime.now().plusDays(5));
        return new Object[][]{new Object[]{reminder}};
    }

    @Test(description = "Delete reminder",
            dataProvider = "deleteReminderData",
            groups = {Teams.GAMMA, Sprints._1})
    @TestCase("REM-171")
    public void deleteReminder(Reminder reminder) {
        NavigationSteps.openRemindersApp();
        ReminderSteps.addReminder(reminder);
        ReminderSteps.deleteLastReminder();
        CommonUiSteps.refreshPage();
        ReminderSteps.checkReminderIsAbsent(reminder);
    }

}
