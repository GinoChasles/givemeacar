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
public class ModelController {

    @GetMapping("/models")
    public @ResponseBody String list() throws IOException {
        return "liste models";
    }

    @GetMapping("/models/{id}")
    public @ResponseBody String get(@PathVariable int id) {
        return "model id : " + Integer.toString(id);
    }

    @PostMapping("/models")
    public @ResponseBody String post(@RequestBody String data) {
        return "Post model";
    }

    @PutMapping("/models/{id}")
    public @ResponseBody String put(@RequestBody String data, @PathVariable int id) {
        return "Put model : " + Integer.toString(id);
    }

    @DeleteMapping("/models/{id}")
    public @ResponseBody String delete(@PathVariable int id) {
        return "Delete model id : " + Integer.toString(id);
    }
}