package com.example.notebook.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "notebook")
public class Notebook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "processor")
    @JsonManagedReference
    private Processor processor;

    private int year;

    private int ram;

    private int storage;


    @ManyToOne
    @JoinColumn(name="graphics")
    @JsonManagedReference
    private Graphics graphics;

    private int price;

    @ManyToOne
    @JoinColumn(name = "screen")
    @JsonManagedReference
    private Screen screen;

    @ManyToOne
    @JoinColumn(name = "type")
    @JsonManagedReference
    private Type type;

}
