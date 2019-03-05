package com.example.notebook.controller;

import com.example.notebook.repository.*;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/find/by-graphics-card")

public class GraphicsController {
    private final GraphicsRepository graphicsRepository;

    @GetMapping("/name")
    public List findAllByGraphicsCardName(@RequestParam String name){
        return graphicsRepository.findAllByGraphicsCardName(name);
    }

   @GetMapping("/version")
    public List findAllByGraphicsCardVersion(@RequestParam String version){
        return graphicsRepository.findAllByGraphicsCardVersion (version);
    }

    @GetMapping("/storage")
    public List findAllByGraphicsCardStorage(@RequestParam String storage){
        return graphicsRepository.findAllByGraphicsCardStorage(storage);
    }

    @GetMapping("/name-storage")
    public List findAllByGraphicsCardNameAndStorage(@RequestParam String name,
                                                    @RequestParam String storage){
        return graphicsRepository.findAllByGraphicsCardNameAndStorage(name, storage);
    }
   @GetMapping("/name-version")
    public List findAllByGraphicsCardNameAndVersion(@RequestParam String name,
                                                    @RequestParam String version){
        return graphicsRepository.findAllByGraphicsCardNameAndVersion(name, version);
    }
}
