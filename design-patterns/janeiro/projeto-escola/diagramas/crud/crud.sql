DROP TABLE Aluno CASCADE CONSTRAINTS;
DROP TABLE Disciplina CASCADE CONSTRAINTS;
DROP TABLE Matricula CASCADE CONSTRAINTS;
DROP TABLE Avaliacao CASCADE CONSTRAINTS;

CREATE TABLE Aluno (
    cd_aluno integer auto_increment,
    nm_aluno varchar(40) NOT NULL,
    nm_mae varchar(40),
    nm_pai varchar(40),
    dt_nascimento Date NOT NULL,
    media_aluno decimal(4,2),
    fl_situacao_aluno char(01),
    PRIMARY KEY (cd_aluno)
);

CREATE TABLE Disciplina (
    cd_disciplina integer auto_increment,
    nm_disciplina varchar(40) NOT NULL,
    nm_professor varchar(40) NOT NULL,
    qtd_avaliacoes int NOT NULL,
    PRIMARY KEY (cd_disciplina)
);

CREATE TABLE Matricula (
    cd_aluno integer NOT NULL,
    cd_disciplina integer NOT NULL,
    dt_matricula Date NOT NULL,
    fl_status_matricula char(01) NOT NULL,
    PRIMARY KEY (cd_aluno, cd_disciplina)
);

CREATE TABLE Avaliacao (
    cd_aluno integer NOT NULL,
    cd_disciplina integer NOT NULL,
    nr_avaliacao integer auto_increment NOT NULL,
    vlr_nota integer NOT NULL,
    PRIMARY KEY (cd_aluno, cd_disciplina, nr_avaliacao)
);

ALTER TABLE Matricula ADD FOREIGN KEY (cd_aluno) REFERENCES Aluno(cd_aluno);
ALTER TABLE Matricula ADD FOREIGN KEY (cd_disciplina) REFERENCES Disciplina(cd_disciplina);
ALTER TABLE Avaliacao ADD FOREIGN KEY (cd_aluno, cd_disciplina) REFERENCES Matricula(cd_aluno,cd_disciplina);