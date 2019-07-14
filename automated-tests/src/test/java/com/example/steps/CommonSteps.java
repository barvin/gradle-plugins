package com.example.steps;

import com.codeborne.selenide.Selenide;

public class CommonSteps {
    public static void refreshPage() {
        Selenide.refresh();
    }
}
