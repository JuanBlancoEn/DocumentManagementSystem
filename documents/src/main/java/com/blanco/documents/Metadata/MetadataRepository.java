package com.blanco.documents.Metadata;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource(collectionResourceRel = "metadata", path = "metadata")
public interface MetadataRepository extends JpaRepository<Metadata, UUID> {
    List<Metadata> findByTitle(@Param("title") String title);
}