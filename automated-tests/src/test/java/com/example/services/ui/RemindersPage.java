package com.example.services.ui;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class RemindersPage {

    public ElementsCollection remindersList() {
        return $$("div.reminder");
    }

    public SelenideElement addReminderTextInput() {
        return $("#add-reminder-text");
    }

    public SelenideElement addReminderDateTimeInput() {
        return $("#add-reminder-date-time input");
    }

    public SelenideElement addButton() {
        return $("#btn-add-reminder");
    }
}
