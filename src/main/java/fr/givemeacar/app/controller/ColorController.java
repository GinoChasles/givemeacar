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
public class ColorController {

    @GetMapping("/colors")
    public @ResponseBody String list() throws IOException {
        return "liste colors";
    }

    @GetMapping("/colors/{id}")
    public @ResponseBody String get(@PathVariable int id) {
        return "color id : " + Integer.toString(id);
    }

    @PostMapping("/colors")
    public @ResponseBody String post(@RequestBody String data) {
        return "Post color";
    }

    @PutMapping("/colors/{id}")
    public @ResponseBody String put(@RequestBody String data, @PathVariable int id) {
        return "Put color : " + Integer.toString(id);
    }

    @DeleteMapping("/colors/{id}")
    public @ResponseBody String delete(@PathVariable int id) {
        return "Delete color id : " + Integer.toString(id);
    }
}