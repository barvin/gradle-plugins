package com.example.sut.controller;

import com.example.sut.data.RemindersStorage;
import com.example.sut.entities.Reminder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/reminder")
public class ReminderController {

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<String> createUpdate(@RequestBody Reminder reminder) {
        try {
            if (reminder.getId() == null) {
                RemindersStorage.add(reminder);
            } else {
                RemindersStorage.update(reminder);
            }
            return ResponseEntity.ok("OK");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Reminder>> read() {
        try {
            return ResponseEntity.ok(RemindersStorage.getAll());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity<String> delete(@PathVariable("id") Integer id) {
        try {
            RemindersStorage.delete(id);
            return ResponseEntity.ok("OK");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
