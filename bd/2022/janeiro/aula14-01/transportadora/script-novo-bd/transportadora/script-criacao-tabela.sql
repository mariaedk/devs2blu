/*
DROP TABLE caminhao CASCADE CONSTRAINTS;
DROP TABLE motorista CASCADE CONSTRAINTS;
DROP TABLE nota_fiscal CASCADE CONSTRAINTS;
DROP TABLE manifesto_carga CASCADE CONSTRAINTS;
DROP TABLE balanca CASCADE CONSTRAINTS;
DROP TABLE manifesto_saida CASCADE CONSTRAINTS;
*/

drop table caminhao;
drop table motorista;
drop table nota_fiscal;
drop table manifesto_carga;
drop table balanca;
drop table manifesto_saida;

CREATE TABLE caminhao (
    nr_placa varchar(09) NOT NULL,
    dt_manutencao Date NOT NULL,
    dt_proxManutencao Date NOT NULL,
    PRIMARY KEY (nr_placa)
);


CREATE TABLE motorista (
    cd_motorista serial NOT NULL,
    nr_CNH integer NOT NULL,
    nm_motorista varchar(30) NOT NULL,
    PRIMARY KEY (cd_motorista, nr_CNH)
);


CREATE TABLE nota_fiscal (
    nr_nota integer NOT NULL,
    dt_emissao Date NOT NULL,
    vl_pesoTotal decimal(7,2) NOT NULL,
    vl_totalNota decimal(9,2) NOT NULL,
    PRIMARY KEY (nr_nota)
);


CREATE TABLE manifesto_carga (
    nr_manifesto integer NOT NULL,
    fk_nr_notaFiscal integer NOT NULL,
    vl_pesoTotal decimal(7,2) NOT NULL,
    qt_volumeCarga integer NOT NULL,
    vl_totalManifesto decimal(10,2) NOT NULL,
    fl_situacao char(01) NOT NULL,
    dt_embarque Date,
    dt_saida Date,
    PRIMARY KEY (nr_manifesto, fk_nr_notaFiscal)
);


CREATE TABLE balanca (
    reg_balanca serial NOT NULL,
    fk_nr_placa varchar(09) NOT NULL,
    fk_nr_CNH integer NOT NULL,
    dt_horaEntrada timestamp NOT NULL,
    dt_horaSaida timestamp,
    vl_pesoEntrada integer NOT NULL,
    vl_pesoSaida integer,
    PRIMARY KEY (reg_balanca)
);


CREATE TABLE manifesto_saida (
    reg_balanca integer NOT NULL,
    nr_manifesto integer NOT NULL,
    PRIMARY KEY (reg_balanca, nr_manifesto)
);

commit;

ALTER TABLE manifesto_carga ADD FOREIGN KEY (fk_nr_notaFiscal) REFERENCES nota_fiscal(nr_nota);
ALTER TABLE balanca ADD FOREIGN KEY (fk_nr_placa) REFERENCES caminhao(nr_placa);
ALTER TABLE balanca ADD FOREIGN KEY (fk_nr_CNH) REFERENCES motorista(nr_CNH);
ALTER TABLE manifesto_saida ADD FOREIGN KEY (reg_balanca) REFERENCES balanca(reg_balanca);
ALTER TABLE manifesto_saida ADD FOREIGN KEY (nr_manifesto) REFERENCES manifesto_carga(nr_manifesto);