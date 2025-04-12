package com.blanco.documents.Institution;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "institution", path = "institution")
public interface InstitutionRepository extends JpaRepository<Institution, UUID> {
    List<Institution> findByIname(@Param("iname") String iname);

}