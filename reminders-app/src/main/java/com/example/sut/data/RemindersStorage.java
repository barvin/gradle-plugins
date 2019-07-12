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

        storage.add(reminder);
    }

    public static List<Reminder> getAll() {
        return new ArrayList<>(storage);
    }

    public static void clearStorage() {
        storage.clear();
    }
}
