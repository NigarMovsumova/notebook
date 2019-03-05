package com.example.notebook.repository;

import com.example.notebook.model.Processor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProcessorRepository extends JpaRepository<Processor, Integer> {
    @Query
            (value = "SELECT notebook.name " +
                    "FROM processor LEFT JOIN notebook " +
                    "ON notebook.processor=processor.id " +
                    "WHERE processor.name = ?1", nativeQuery = true)
    List findAllByProcessorName(String name);

    @Query
            (value = "SELECT notebook.name " +
                    "FROM processor LEFT JOIN notebook " +
                    "ON notebook.processor=processor.id " +
                    "WHERE processor.name = :name " +
                    "AND processor.version= :version", nativeQuery = true)
    List findAllByProcessorNameAndVersion(@Param("name") String name,
                                          @Param("version") String version);

    @Query(value = "SELECT notebook.name " +
            "FROM processor LEFT JOIN notebook " +
            " ON notebook.processor=processor.id " +
            "WHERE processor.frequency= :frequency", nativeQuery = true)
    List findAllByProcessorFrequency(@Param("frequency") Integer frequency);

    @Query(value = "SELECT notebook.name " +
            "FROM processor LEFT JOIN notebook " +
            "ON notebook.processor= processor.id " +
            "WHERE processor.version= :version", nativeQuery = true)
    List findAllByProcessorVersion(@Param("version") String version);

    @Query(value = "SELECT notebook.name " +
            "FROM processor LEFT JOIN notebook " +
            "ON notebook.processor = processor.id " +
            "WHERE processor.core = ?1", nativeQuery = true)
    List findAllByProcessorCoreCount(int core);

    @Query(value = "SELECT notebook.name " +
            "FROM processor LEFT JOIN notebook " +
            "ON notebook.processor= processor.id " +
            "WHERE processor.core= ?1 " +
            "AND processor.frequency= ?2", nativeQuery = true)
    List findAllByProcessorCoreAndFrequency(Integer core, Integer frequency);

    @Query(value = "SELECT notebook.name, notebook.price, notebook.type " +
            "FROM processor LEFT JOIN notebook " +
            "ON notebook.processor=processor.id " +
            "WHERE processor.version= ?1 " +
            "AND processor.core= ?2 " +
            "AND processor.frequency= ?3", nativeQuery = true)
    List findAllByProcessorVersionCoreAndFrequency(String version, Integer core, Integer frequency);

    @Query(value = "SELECT notebook.name " +
            "FROM processor LEFT JOIN notebook " +
            "ON notebook.processor = processor.id " +
            "WHERE processor.name= ?1 " +
            "AND processor.version= ?2 " +
            "AND processor.core= ?3", nativeQuery = true)
    List findAllByProcessorNameVersionAndCore(String name, String version, int core);
}
