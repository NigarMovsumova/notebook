package com.example.notebook.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "graphics")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Graphics {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String version;

    private int storage;

    @OneToMany(mappedBy = "graphics")
    @JsonBackReference
    private Set<Notebook> notebookSet ;


}
