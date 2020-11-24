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
public class GeolocationController {

    @GetMapping("/geolocations")
    public @ResponseBody String list() throws IOException {
        return "liste geolocations";
    }

    @GetMapping("/geolocations/{id}")
    public @ResponseBody String get(@PathVariable int id) {
        return "geolocation id : " + Integer.toString(id);
    }

    @PostMapping("/geolocations")
    public @ResponseBody String post(@RequestBody String data) {
        return "Post geolocation";
    }

    @PutMapping("/geolocations/{id}")
    public @ResponseBody String put(@RequestBody String data, @PathVariable int id) {
        return "Put geolocation : " + Integer.toString(id);
    }

    @DeleteMapping("/geolocations/{id}")
    public @ResponseBody String delete(@PathVariable int id) {
        return "Delete geolocation id : " + Integer.toString(id);
    }
}