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
public class EnergyController {

    @GetMapping("/energies")
    public @ResponseBody String list() throws IOException {
        return "liste energies";
    }

    @GetMapping("/energies/{id}")
    public @ResponseBody String get(@PathVariable int id) {
        return "energy id : " + Integer.toString(id);
    }

    @PostMapping("/energies")
    public @ResponseBody String post(@RequestBody String data) {
        return "Post energy";
    }

    @PutMapping("/energies/{id}")
    public @ResponseBody String put(@RequestBody String data, @PathVariable int id) {
        return "Put energy : " + Integer.toString(id);
    }

    @DeleteMapping("/energies/{id}")
    public @ResponseBody String delete(@PathVariable int id) {
        return "Delete energy id : " + Integer.toString(id);
    }
}