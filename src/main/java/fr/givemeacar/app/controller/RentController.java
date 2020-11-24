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
public class RentController {

    @GetMapping("/rents")
    public @ResponseBody String list() throws IOException {
        return "liste rents";
    }

    @GetMapping("/rents/{id}")
    public @ResponseBody String get(@PathVariable int id) {
        return "rent id : " + Integer.toString(id);
    }

    @PostMapping("/rents")
    public @ResponseBody String post(@RequestBody String data) {
        return "Post rent";
    }

    @PutMapping("/rents/{id}")
    public @ResponseBody String put(@RequestBody String data, @PathVariable int id) {
        return "Put rent : " + Integer.toString(id);
    }

    @DeleteMapping("/rents/{id}")
    public @ResponseBody String delete(@PathVariable int id) {
        return "Delete rent id : " + Integer.toString(id);
    }
}