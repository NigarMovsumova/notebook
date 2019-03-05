package com.example.notebook.controller;

import com.example.notebook.model.Screen;
import com.example.notebook.repository.*;
import com.example.notebook.model.Screen;
import com.example.notebook.repository.ScreenRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("find/by-screen")
public class ScreenController {
    private final ScreenRepository repository;


    @GetMapping("/all")
    public List findAllScreens() {
        return repository.findAll();
    }

    @GetMapping("/diagonal-size")
    public List findAllByScreenDiagonalSize(@RequestParam int diagonal) {
        return repository.findAllByScreenDiagonalSize(diagonal);
    }
    @GetMapping("/matrix-type")
    public List findAllByScreenMatrixType (@RequestParam String matrix){
        return repository.findAllByScreenMatrixType(matrix);
    }
    @GetMapping("/resolution")
    public List findAllByScreenResolution(@RequestParam String resolution){
        return repository.findAllByScreenResolution(resolution);
    }
    @GetMapping("/diagonal-and-resolution")
    public List findAllByScreenDiagonalAndResolution(@RequestParam int diagonal,
                                                     @RequestParam String resolution){
        return repository.findAllByScreenDiagonalAndResolution(diagonal, resolution);
    }
    @GetMapping("/matrix-resolution")
    public List findAllByScreenMatrixAndResolution (@RequestParam String matrix,
                                                    @RequestParam String resolution){
        return repository.findAllByScreenMatrixAndResolution(matrix, resolution);
    }

    @GetMapping("/diagonal-resolution-matrix")
    public List findAllByDiagonalResolutionAndMatrix(@RequestParam int diagonal,
                                                     @RequestParam String resolution,
                                                     @RequestParam String matrix){
        return repository.findAllByScreenDiagonalResolutionAndMatrix(diagonal,resolution, matrix);
    }

}
