package com.example.services.ui;

import com.codeborne.selenide.SelenideElement;

public class RemindersListItem {
    private SelenideElement rootElement;

    public RemindersListItem(SelenideElement rootElement) {
        this.rootElement = rootElement;
    }

    public SelenideElement doneCheckBox() {
        return rootElement.$(".is-done");
    }

    public SelenideElement textInput() {
        return rootElement.$(".reminder-text");
    }

    public SelenideElement dateTimeInput() {
        return rootElement.$(".reminder-date");
    }

    public SelenideElement updateButton() {
        return rootElement.$(".update");
    }

    public SelenideElement deleteButton() {
        return rootElement.$(".delete");
    }
}
