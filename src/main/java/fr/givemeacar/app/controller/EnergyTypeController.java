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
public class EnergyTypeController {

    @GetMapping("/energytypes")
    public @ResponseBody String list() throws IOException {
        return "liste energytypes";
    }

    @GetMapping("/energytypes/{id}")
    public @ResponseBody String get(@PathVariable int id) {
        return "energytype id : " + Integer.toString(id);
    }

    @PostMapping("/energytypes")
    public @ResponseBody String post(@RequestBody String data) {
        return "Post energytype";
    }

    @PutMapping("/energytypes/{id}")
    public @ResponseBody String put(@RequestBody String data, @PathVariable int id) {
        return "Put energytype : " + Integer.toString(id);
    }

    @DeleteMapping("/energytypes/{id}")
    public @ResponseBody String delete(@PathVariable int id) {
        return "Delete energytype id : " + Integer.toString(id);
    }
}