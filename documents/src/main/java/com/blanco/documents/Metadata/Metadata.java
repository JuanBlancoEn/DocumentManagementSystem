package com.blanco.documents.Metadata;

import java.util.Date;
import java.util.UUID;

import com.blanco.documents.Institution.Institution;
import com.blanco.documents.User.User;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Metadata_documents")
public class Metadata {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false) // FK en la tabla Metadata
    private User userId;

    @Column
    private String title;

    @Column
    private String author;

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date create_date;

    @ManyToOne // Indica que cada Metadata pertenece a una Institution
    @JoinColumn(name = "institution_id", referencedColumnName = "id", nullable = false) // FK en la tabla Metadata
    private Institution institution;

    @Column
    private String path;

    // Constructores
    public Metadata() {}

    public Metadata(User userId, String title, String author, Date create_date, Institution institution, String path) {
        this.userId = userId;
        this.title = title;
        this.author = author;
        this.create_date = create_date;
        this.institution = institution;
        this.path = path;
    }
}
