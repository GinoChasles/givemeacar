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
public class StreetTypeController {

    @GetMapping("/streettypes")
    public @ResponseBody String list() throws IOException {
        return "liste streettypes";
    }

    @GetMapping("/streettypes/{id}")
    public @ResponseBody String get(@PathVariable int id) {
        return "streettype id : " + Integer.toString(id);
    }

    @PostMapping("/streettypes")
    public @ResponseBody String post(@RequestBody String data) {
        return "Post streettype";
    }

    @PutMapping("/streettypes/{id}")
    public @ResponseBody String put(@RequestBody String data, @PathVariable int id) {
        return "Put streettype : " + Integer.toString(id);
    }

    @DeleteMapping("/streettypes/{id}")
    public @ResponseBody String delete(@PathVariable int id) {
        return "Delete streettype id : " + Integer.toString(id);
    }
}