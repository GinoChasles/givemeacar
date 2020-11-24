package fr.givemeacar.app.controllers;

import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.file.Files;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.ClassPathResource;

@RestController
public class AgencyController {
    ResourceLoader resourceLoader;

    // new String(Files.readAllBytes(new
    // ClassPathResource("data.json").getFile().toPath()))

    @GetMapping("/api/agencies")
    public @ResponseBody String list() throws IOException {
        return "Un liste d'agences!!!!";
    }

    @GetMapping("/api/agencies/{id}")
    public @ResponseBody String get(@PathVariable int id) {
        return " Get Agence " + Integer.toString(id);
    }

    @PostMapping("/api/agencies")
    public @ResponseBody String post(@RequestBody String data) {
        return "Post Agence " + data;
    }

    @PutMapping("/api/agencies/{id}")
    public @ResponseBody String put(@RequestBody String data, @PathVariable int id) {
        return "Put Agence " + Integer.toString(id);
    }

    @DeleteMapping("/api/agencies/{id}")
    public @ResponseBody String delete(@PathVariable int id) {
        return "Delete Agence " + Integer.toString(id);
    }
}