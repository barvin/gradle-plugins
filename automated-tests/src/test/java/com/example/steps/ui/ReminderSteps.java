package com.example.steps.ui;

import com.example.entities.generated.Reminder;
import com.example.services.ui.RemindersListItem;
import com.example.services.ui.RemindersPage;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Condition.checked;
import static com.codeborne.selenide.Condition.value;
import static org.assertj.core.api.Assertions.assertThat;

public class ReminderSteps {
    private static RemindersPage remindersPage = new RemindersPage();

    public static void addReminder(Reminder reminder) {
        remindersPage.addReminderTextInput().setValue(reminder.getText());
        remindersPage.addReminderDateTimeInput()
                .setValue(reminder.getTime().format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm")));
        remindersPage.addButton().click();
    }

    public static void checkLastReminder(Reminder reminder) {
        RemindersListItem reminderUiRow = new RemindersListItem(remindersPage.remindersList().last());
        reminderUiRow.textInput().shouldHave(value(reminder.getText()));
        reminderUiRow.dateTimeInput().shouldHave(value(
                reminder.getTime().format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm"))));
        if (reminder.isDone()) {
            reminderUiRow.doneCheckBox().shouldBe(checked);
        } else {
            reminderUiRow.doneCheckBox().shouldNotBe(checked);
        }
    }

    public static void updateLastReminder(Reminder reminder) {
        RemindersListItem reminderUiRow = new RemindersListItem(remindersPage.remindersList().last());
        reminderUiRow.textInput().setValue(reminder.getText());
        reminderUiRow.dateTimeInput().setValue(
                reminder.getTime().format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm")));
        reminderUiRow.doneCheckBox().setSelected(reminder.isDone());
        reminderUiRow.updateButton().click();
    }

    public static void deleteLastReminder() {
        RemindersListItem reminderUiRow = new RemindersListItem(remindersPage.remindersList().last());
        reminderUiRow.deleteButton().click();
    }

    public static void checkReminderIsAbsent(Reminder reminder) {
        List<String> remindersTextsList = remindersPage.remindersList().stream().map(
                rowRootElement -> new RemindersListItem(rowRootElement).textInput().getValue())
                .collect(Collectors.toList());
        assertThat(remindersTextsList).doesNotContain(reminder.getText());
    }
}
