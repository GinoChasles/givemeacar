package fr.givemeacar.app.controller;

import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RestController
@RequestMapping("/api")
public class ClientController {

    @GetMapping("/clients")
    public @ResponseBody String list() throws IOException {
        return "list clients";
    }

    @GetMapping("/clients/{id}")
    public @ResponseBody String get(@PathVariable int id) {
        return "client id : " + Integer.toString(id);
    }

    @PostMapping("/clients")
    public @ResponseBody String post(@RequestBody String data) {
        return "Post client";
    }

    @PutMapping("/clients/{id}")
    public @ResponseBody String put(@RequestBody String data, @PathVariable int id) {
        return "Put client : " + Integer.toString(id);
    }

    @DeleteMapping("/clients/{id}")
    public @ResponseBody String delete(@PathVariable int id) {
        return "Delete client id : " + Integer.toString(id);
    }
}