package com.example.steps.api;

import com.example.entities.generated.Reminder;
import io.restassured.response.ResponseBody;

public class RemindersApiSteps extends BaseApiSteps {

    public static void addReminder(Reminder reminder) {
        apiClient.reminderController().createUpdateUsingPUT().body(reminder).execute(ResponseBody::prettyPrint);
    }
}
