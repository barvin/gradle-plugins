package com.example.steps;

import static com.codeborne.selenide.Selenide.open;

public class NavigationSteps {

    private static final String SUT_URL = System.getProperty("sut.url", "http://localhost:8080");

    public static void openRemindersApp() {
        open(SUT_URL);
    }

}
