package com.blanco.documents.Institution;

import java.util.UUID;

import jakarta.persistence.*;

@Entity
@Table(name = "Institutions")
public class Institution {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column
    private String iname;

    @Column
    private String abbrev;

    @Column
    private String alternative;

    public Institution() {}

    public Institution(String iname, String abbrev) {
        this.iname = iname;
        this.abbrev = abbrev;
    }

    public Institution(String iname, String abbrev, String alternative) {
        this.iname = iname;
        this.abbrev = abbrev;
        this.alternative = alternative;
    }
}
