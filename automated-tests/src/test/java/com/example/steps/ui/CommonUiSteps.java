package com.example.steps.ui;

import com.codeborne.selenide.Selenide;

public class CommonUiSteps {
    public static void refreshPage() {
        Selenide.refresh();
    }
}
