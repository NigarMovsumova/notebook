package com.example.notebook.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "screen")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Screen {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private int diagonal;

    private int resolution;

    private String matrix;

    @OneToMany(mappedBy = "screen")
    @JsonBackReference
    private Set<Notebook> notebookSet;
}
