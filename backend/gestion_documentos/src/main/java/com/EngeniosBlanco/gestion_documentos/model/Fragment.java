package com.EngeniosBlanco.gestion_documentos.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "Fragments")
public class Fragment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "documentoId", nullable = false)
    private String documentoId;

    @Column(name = "fragmentId", nullable = false, unique = true)
    private String fragmentId;

    // Constructor sin parámetros (requerido por JPA)
    public Fragment() {}

    // Constructor con parámetros
    public Fragment(String documentoId, String fragmentId) {
        this.documentoId = documentoId;
        this.fragmentId = fragmentId;
    }

    @Override
    public String toString() {
        return "Fragment{id=" + id + ", fragmentId='" + fragmentId + "'}";
    }
}