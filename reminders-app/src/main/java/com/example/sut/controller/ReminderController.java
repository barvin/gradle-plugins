package com.example.sut.controller;

import com.example.sut.entities.Reminder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletContext;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/reminder")
public class ReminderController {

    @Autowired
    private ServletContext servletContext;

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<String> create(@RequestBody Reminder reminder) {
        return ResponseEntity.ok("OK");
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<String> update(@RequestBody Reminder reminder) {
        return ResponseEntity.ok("OK");
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Reminder>> read() {
        try {
            return ResponseEntity.ok(Collections.singletonList(new Reminder()));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
