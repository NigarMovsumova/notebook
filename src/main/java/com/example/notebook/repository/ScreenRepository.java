package com.example.notebook.repository;

import com.example.notebook.model.Screen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ScreenRepository extends JpaRepository<Screen, Integer> {

    @Query
            (value = "SELECT notebook.name " +
                    "FROM screen LEFT JOIN notebook " +
                    "ON notebook.screen=screen.id" +
                    " WHERE screen.diagonal = ?1", nativeQuery = true)
     List findAllByScreenDiagonalSize(int diagonal);

    @Query(value = "SELECT notebook.name " +
            "FROM screen LEFT JOIN notebook " +
            "ON notebook.screen= screen.id " +
            "WHERE screen.matrix= ?1", nativeQuery = true)
    List findAllByScreenMatrixType(String matrix);

    @Query(value = "SELECT notebook.name " +
            "FROM screen LEFT JOIN notebook " +
            "ON notebook.screen= screen.id " +
            "WHERE screen.resolution= ?1", nativeQuery = true)
    List findAllByScreenResolution(String resolution);

    @Query(value = "SELECT notebook.name " +
            "FROM screen LEFT JOIN notebook " +
            "ON notebook.screen= screen.id " +
            "WHERE screen.diagonal= ?1 " +
            "AND screen.resolution= ?2", nativeQuery = true)
    List findAllByScreenDiagonalAndResolution(int diagonal, String resolution);

    @Query(value = "SELECT notebook.name " +
            "FROM screen LEFT JOIN notebook " +
            "on notebook.screen= screen.id " +
            "WHERE screen.diagonal= ?1 " +
            "AND screen.resolution= ?2 " +
            "AND screen.matrix= ?3", nativeQuery = true)
    List findAllByScreenDiagonalResolutionAndMatrix
            (int diagonal, String resolution, String matrix);

    @Query(value = "SELECT notebook.name " +
            "FROM screen LEFT JOIN notebook " +
            "on notebook.screen= screen.id " +
            "WHERE screen.matrix= ?1 " +
            "AND screen.resolution= ?2", nativeQuery = true)
    List findAllByScreenMatrixAndResolution(String matrix, String resolution);
}
