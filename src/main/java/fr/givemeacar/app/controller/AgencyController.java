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
public class AgencyController {

    @GetMapping("/agencies")
    public @ResponseBody String list() throws IOException {
        return "list agency";
    }

    @GetMapping("/agencies/{id}")
    public @ResponseBody String get(@PathVariable int id) {
        return "gency id : " + Integer.toString(id);
    }

    @PostMapping("/agencies")
    public @ResponseBody String post(@RequestBody String data) {
        return "Post gency";
    }

    @PutMapping("/agencies/{id}")
    public @ResponseBody String put(@RequestBody String data, @PathVariable int id) {
        return "Put gency : " + Integer.toString(id);
    }

    @DeleteMapping("/agencies/{id}")
    public @ResponseBody String delete(@PathVariable int id) {
        return "Delete gency id : " + Integer.toString(id);
    }
}