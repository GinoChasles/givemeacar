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
public class AdministratorController {

    @GetMapping("/administrators")
    public @ResponseBody String list() throws IOException {
        return "liste administrator";
    }

    @GetMapping("/administrators/{id}")
    public @ResponseBody String get(@PathVariable int id) {
        return "administrator id : " + Integer.toString(id);
    }

    @PostMapping("/administrators")
    public @ResponseBody String post(@RequestBody String data) {
        return "Post administrator";
    }

    @PutMapping("/administrators/{id}")
    public @ResponseBody String put(@RequestBody String data, @PathVariable int id) {
        return "Put administrator : " + Integer.toString(id);
    }

    @DeleteMapping("/administrators/{id}")
    public @ResponseBody String delete(@PathVariable int id) {
        return "Delete administrator id : " + Integer.toString(id);
    }
}