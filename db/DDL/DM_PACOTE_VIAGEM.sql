CREATE TABLE DM_PACOTE_VIAGEM (
    id                INTEGER      PRIMARY KEY AUTOINCREMENT,
    id_destino        INTEGER,
    categoria         VARCHAR (30) CHECK (categoria IN ('Aventura', 'Relaxamento', 'Cultura') ),
    plano             VARCHAR (30) CHECK (plano IN ('Premium', 'Basico', 'Lite') ),
    avaliacao         INTEGER      CHECK (avaliacao >= 0 AND 
                                          avaliacao <= 10),
    precoBase         REAL,
    descontoBase      REAL,
    categoria_destino VARCHAR (30) CHECK (categoria_destino IN ('MONTANHA', 'DESERTO', 'PRAIA', 'TROPICAL', 'METROPOLE') ),
    FOREIGN KEY (
        id_destino
    )
    REFERENCES DM_DESTINOS (id) 
);
