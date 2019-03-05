package com.example.notebook.controller;

import com.example.notebook.repository.*;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("find/by-processor")
@AllArgsConstructor
@RestController
public class ProcessorController {
    private final ProcessorRepository processorRepository;

    @GetMapping("/name")
        public List findAllByProcessorName(@RequestParam String name){
            return processorRepository.findAllByProcessorName(name);
        }

    @GetMapping("/version")
    public List findAllByProcessorVersion(@RequestParam String version){
        return processorRepository.findAllByProcessorVersion(version);
    }

    @GetMapping("/name-and-version")
    public List findAllByProcessorNameAndVersion(@RequestParam String name,
                                                 @RequestParam String version){
        return processorRepository.findAllByProcessorNameAndVersion(name, version);
    }
    @GetMapping("/core")
    public List findAllByProcessorCoreCount(@RequestParam int core){
        return processorRepository.findAllByProcessorCoreCount(core);
    }

    @GetMapping("/frequency")
    public List findAllByProcessorFrequency(@RequestParam int frequency){
        return processorRepository.findAllByProcessorFrequency(frequency);
    }

    @GetMapping("/core-and-frequency")
    public List findAllByProcessorCoreAndFrequency(@RequestParam Integer core,
                                                   @RequestParam Integer frequency){
        return processorRepository.findAllByProcessorCoreAndFrequency(core, frequency);
    }

    @GetMapping("/version-core-frequency")
    public List findAllByProcessorVersionCoreAndFrequency(@RequestParam String version,
                                                 @RequestParam Integer core,
                                                 @RequestParam Integer frequency){
        return processorRepository.findAllByProcessorVersionCoreAndFrequency(version, core, frequency);
    }
    @GetMapping("/name-version-core")
    public List findAllByProcessorNameVersionAndCore(@RequestParam String name,
                                                     @RequestParam String version,
                                                     @RequestParam Integer core){
        return processorRepository.findAllByProcessorNameVersionAndCore(name, version, core);
    }

}
