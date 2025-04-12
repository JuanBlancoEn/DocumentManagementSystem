CREATE TABLE Users (
	id VARCHAR(36) NOT NULL ,
    username VARCHAR(50) NOT NULL,
    password VARCHAR(255) NOT NULL,
    PRIMARY KEY(id),
    CONSTRAINT UNIQUE (username)
);

CREATE TABLE Metadata_documents (
	id INT NOT NULL AUTO_INCREMENT,
    userId VARCHAR(36) NOT NULL,
    title VARCHAR(255),
    author VARCHAR(255),
    document_type ENUM('general', 'guia_curso', 'guia_grado') NOT NULL,
    institution VARCHAR(255),
    degree VARCHAR(255),
    creation_date DATETIME,
    route VARCHAR(255),
    vote_score INT,
    revised BOOLEAN,
    PRIMARY KEY(id),
    FOREIGN KEY(userId) REFERENCES Users(id)
);

