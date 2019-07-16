package com.example.steps.ui;

import static com.codeborne.selenide.Selenide.open;

public class NavigationSteps {

    public static void openRemindersApp() {
        open("http://localhost:8080");
    }

}
