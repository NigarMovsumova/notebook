package com.example.notebook.repository;

import com.example.notebook.model.Notebook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotebookRepository extends JpaRepository<Notebook, Integer> {

    @Query
            (value = "SELECT * FROM notebook WHERE price= ?1", nativeQuery = true)
    List findAllByPrice(int price);

    @Query
            (value = "SELECT * FROM notebook WHERE ram= ?1", nativeQuery = true)
    List findAllByRam(int price);

    @Query
            (value = "SELECT * FROM notebook WHERE name= ?1", nativeQuery = true)
    List findAllByName(String name);

    @Query
            (value = "SELECT * FROM notebook WHERE year= ?1", nativeQuery = true)
    List findAllByIssueYear(int year);


    @Query(value = "SELECT * FROM notebook " +
                   "WHERE price= ?1 AND year= ?2", nativeQuery = true)
    List findAllByTypePriceAndIssueYear(int price, int year);

    @Query(value = "SELECT * FROM notebook " +
                    "WHERE name= ?1 " +
                    "AND ram= ?2", nativeQuery = true)
    List findAllByNotebookNameAndRam(String name, int ram);

    @Query(value = "SELECT * FROM notebook " +
            "WHERE name= ?1 " +
            "AND year= ?2", nativeQuery = true)
    List findAllByNameAndYear(String name, int year);

    @Query
            (value = "SELECT * FROM notebook " +
                    "WHERE name= ?1 " +
                    "AND year= ?2 " +
                    "AND price= ?3", nativeQuery = true)
    List findAllByNameYearAndPrice(String name, int year, int price);
}
