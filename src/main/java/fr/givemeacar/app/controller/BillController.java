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
public class BillController {

    @GetMapping("/bills")
    public @ResponseBody String list() throws IOException {
        return "liste bills";
    }

    @GetMapping("/bills/{id}")
    public @ResponseBody String get(@PathVariable int id) {
        return "bill id : " + Integer.toString(id);
    }

    @PostMapping("/bills")
    public @ResponseBody String post(@RequestBody String data) {
        return "Post bill";
    }

    @PutMapping("/bills/{id}")
    public @ResponseBody String put(@RequestBody String data, @PathVariable int id) {
        return "Put bill : " + Integer.toString(id);
    }

    @DeleteMapping("/bills/{id}")
    public @ResponseBody String delete(@PathVariable int id) {
        return "Delete bill id : " + Integer.toString(id);
    }
}