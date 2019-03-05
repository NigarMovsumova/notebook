package com.example.notebook.controller;

import com.example.notebook.repository.NotebookRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/find")
@RestController
@AllArgsConstructor
public class NotebookController {
    private final NotebookRepository notebookRepository;

    @GetMapping("/all")
    public List findAll() {
        return notebookRepository.findAll();
    }

    @GetMapping("/by-price")
    public List findAllByPrice(@RequestParam int price) {
        return notebookRepository.findAllByPrice(price);
    }

    @GetMapping("/by-ram")
    public List findAllByRam(@RequestParam int ram){
        return notebookRepository.findAllByRam(ram);
    }

    @GetMapping("/by-notebook-name")
    public List findAllByName(@RequestParam String name){
       return notebookRepository.findAllByName(name);
    }

    @GetMapping("/by-issue-year")
    public List findAllByYearOfIssue (@RequestParam int year){
        return notebookRepository.findAllByIssueYear(year);
    }

    @GetMapping("/by-price-and-issue-year")
    public List findAllByPriceAndIssueYear(@RequestParam int price,
                                           @RequestParam int year){
        return notebookRepository.findAllByTypePriceAndIssueYear(price, year);
    }

    @GetMapping("/by-name-year")
    public List findAllByNameAndIssueYear(@RequestParam String name,
                                          @RequestParam int year){
        return notebookRepository.findAllByNameAndYear(name, year);
    }
    @GetMapping("/by-name-and-ram")
    public List findAllByNotebookNameAndRam(@RequestParam String name,
                                            @RequestParam int ram){
        return  notebookRepository.findAllByNotebookNameAndRam(name, ram);
    }
    @GetMapping("/by-name-year-price")
    public List findAllByNotebookNameYearAndPrice(@RequestParam String name,
                                                  @RequestParam int year,
                                                  @RequestParam int price){
        return notebookRepository.findAllByNameYearAndPrice(name, year, price);
    }



}
