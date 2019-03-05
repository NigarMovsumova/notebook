package com.example.notebook.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "processor")
public class Processor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String version;

    private int core;

    private Integer frequency;

    @OneToMany(mappedBy = "processor")
    @JsonBackReference
    private Set<Notebook> notebookSet ;
}
