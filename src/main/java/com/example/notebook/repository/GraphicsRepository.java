package com.example.notebook.repository;

import com.example.notebook.model.Graphics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GraphicsRepository extends JpaRepository<Graphics, Integer> {
    @Query
            (value = "SELECT notebook.name " +
                    "FROM graphics LEFT JOIN notebook " +
                    "ON graphics.id=notebook.graphics " +
                    "WHERE graphics.name= ?1", nativeQuery = true)
    List findAllByGraphicsCardName(String name);

    @Query(value = "SELECT notebook.name " +
            "FROM graphics LEFT JOIN notebook " +
            "ON graphics.id= notebook.graphics " +
            "WHERE graphics.version= ?1", nativeQuery = true)
    List findAllByGraphicsCardVersion(String version);

    @Query(value = "SELECT notebook.name " +
            "FROM graphics LEFT JOIN notebook " +
            "ON graphics.id= notebook.graphics " +
            "WHERE graphics.storage= ?1", nativeQuery = true)
    List findAllByGraphicsCardStorage(String storage);

    @Query(value="SELECT notebook.name " +
            "FROM graphics LEFT JOIN notebook " +
            "ON graphics.id= notebook.graphics " +
            "WHERE graphics.name= ?1 " +
            "AND graphics.storage= ?2", nativeQuery = true)
    List findAllByGraphicsCardNameAndStorage(String name, String storage);

   @Query(value = " SELECT notebook.name " +
           "FROM graphics LEFT JOIN notebook " +
           "ON graphics.id= notebook.graphics " +
           "WHERE graphics.name= ?1 " +
           "AND graphics.version= ?2", nativeQuery = true)
    List findAllByGraphicsCardNameAndVersion(String name, String version);

}
