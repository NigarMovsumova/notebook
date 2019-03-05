package com.example.notebook.repository;

import com.example.notebook.model.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TypeRepository extends JpaRepository<Type, Integer> {

@Query(value = "SELECT notebook.name " +
        "FROM type LEFT JOIN notebook " +
        "ON type.id= notebook.type " +
        "WHERE type.name= ?1", nativeQuery = true)
    List findAllByNotebookType(String name);
}
