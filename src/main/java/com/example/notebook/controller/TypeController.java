package com.example.notebook.controller;

import com.example.notebook.repository.TypeRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class TypeController {
    private final TypeRepository typeRepository;
    @GetMapping("/find-by-notebook-type")
    public List findAllByNotebookType(@RequestParam String name) {
        return typeRepository.findAllByNotebookType(name);
    }
}
