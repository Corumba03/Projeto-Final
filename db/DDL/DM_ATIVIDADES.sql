CREATE TABLE DM_ATIVIDADES (
    id              INTEGER      PRIMARY KEY AUTOINCREMENT,
    nome            VARCHAR (20) NOT NULL,
    resumo          TEXT,
    descricao       TEXT,
    duracao         VARCHAR (20),
    dificuldade     VARCHAR (30) CHECK (dificuldade IN ('Facil', 'Moderado', 'Dificil', 'Perigoso') ),
    disponibilidade VARCHAR (20),
    cuidados        TEXT,
    equipamentos    TEXT
);