package fr.givemeacar.app.controller;

import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.file.Files;

import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RestController
public class IndexController {

    @RequestMapping("/")
    public @ResponseBody String list() throws IOException {
        return new String(Files.readAllBytes(new ClassPathResource("public/givemeacar/public/index.html").getFile().toPath()));
    }

}