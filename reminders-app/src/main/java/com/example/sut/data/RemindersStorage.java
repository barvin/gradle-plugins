package com.example.sut.data;

import com.example.sut.entities.Reminder;

import java.util.ArrayList;
import java.util.List;

public class RemindersStorage {
    private static List<Reminder> storage = new ArrayList<>();

    public static void add(Reminder reminder) {
        storage.add(reminder);
    }

    public static void update(Reminder reminder) {
        Reminder existingReminder = storage.get(reminder.getId());
        existingReminder.setText(reminder.getText());
        existingReminder.setTime(reminder.getTime());
        existingReminder.setDone(reminder.isDone());
    }

    public static List<Reminder> getAll() {
        return new ArrayList<>(storage);
    }

    public static void delete(Integer id) {
        if (id != null && id >= 0 && id < storage.size()) {
            storage.remove(id.intValue());
        }
    }

    public static void clearStorage() {
        storage.clear();
    }
}
