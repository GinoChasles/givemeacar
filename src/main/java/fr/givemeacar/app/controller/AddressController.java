package fr.givemeacar.app.controller;

import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@RestController
@RequestMapping("/api")
public class AddressController {

    @GetMapping("/addresses")
    public @ResponseBody String list() {
        return "liste address";
    }

    @GetMapping("/addresses/{id}")
    public @ResponseBody String get(@PathVariable int id) {
        return "address id : " + Integer.toString(id);
    }

    @PostMapping("/addresses")
    public @ResponseBody String post(@RequestBody String data) {
        return "Post address";
    }

    @PutMapping("/addresses/{id}")
    public @ResponseBody String put(@RequestBody String data, @PathVariable int id) {
        return "Put address : " + Integer.toString(id);
    }

    @DeleteMapping("/addresses/{id}")
    public @ResponseBody String delete(@PathVariable int id) {
        return "Delete address id : " + Integer.toString(id);
    }
}