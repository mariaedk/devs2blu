/* 
    nr_placa varchar(09) NOT NULL,
    dt_manutencao Date NOT NULL,
    dt_proxManutencao Date NOT NULL,
    PRIMARY KEY (nr_placa)
*/


-- caminhao

insert into caminhao
values ('PCK-5458', '2020-12-22', '2022-03-02');

insert into caminhao
values ('QHZ-3721', '2021-11-11', '2023-01-17');

insert into caminhao
values ('REF-8963', '2020-04-17', '2022-07-28');

insert into caminhao
values ('LOK-3322', '2019-09-11', '2022-02-08');

insert into caminhao
values ('THZ-2012', '2021-06-24', '2022-08-23');


-- motorista

insert into motorista(nr_cnh, nm_motorista)
values (5672654, 'Miguel Ferreira');

insert into motorista (nr_cnh, nm_motorista)
values (7509511, 'Emily Lima Gomes');

insert into motorista (nr_cnh, nm_motorista)
values (8040459, 'Kauê Goncalves Rocha');

insert into motorista (nr_cnh, nm_motorista)
values (7536707, 'Alice Melo Pereira');

insert into motorista (nr_cnh, nm_motorista)
values (1923821, 'Paulo Gomes Cavalcanti');


-- nota fiscal

insert into nota_fiscal(nr_nota, dt_emissao, vl_pesototal, vl_totalnota)
values (1, '2021-12-22', 300.00, 3254.60);

insert into nota_fiscal(nr_nota, dt_emissao, vl_pesototal, vl_totalnota)
values (2, '2022-01-10', 400.00, 5300.70);

insert into nota_fiscal(nr_nota, dt_emissao, vl_pesototal, vl_totalnota)
values (3, '2020-11-10', 100.00, 1204.00);

insert into nota_fiscal(nr_nota, dt_emissao, vl_pesototal, vl_totalnota)
values (4, '2021-10-23', 600.00, 4050.20);

insert into nota_fiscal(nr_nota, dt_emissao, vl_pesototal, vl_totalnota)
values (5, '2022-01-05', 900.00, 12054.60);

insert into nota_fiscal(nr_nota, dt_emissao, vl_pesototal, vl_totalnota)
values (6, '2021-12-23', 460.00, 7050.00);

insert into nota_fiscal(nr_nota, dt_emissao, vl_pesototal, vl_totalnota)
values (7, '2022-01-02', 130.00, 1504.40);

insert into nota_fiscal(nr_nota, dt_emissao, vl_pesototal, vl_totalnota)
values (8, '2021-05-23', 30.00, 800.00);

insert into nota_fiscal(nr_nota, dt_emissao, vl_pesototal, vl_totalnota)
values (9, '2022-01-09', 150.00, 950.49);

select * from nota_fiscal;

select sum(nota_fiscal.vl_pesototal), sum(nota_fiscal.vl_totalnota)
from nota_fiscal  
where nota_fiscal.nr_nota in (7,8,9);


-- manifesto 1

INSERT INTO public.manifesto_carga
(nr_manifesto, fk_nr_notafiscal, vl_pesototal, qt_volumecarga, vl_totalmanifesto, fl_situacao, dt_embarque, dt_saida)
VALUES(1, 1, 800, 80, 9759.30, 'E', '2021-12-22', null);

INSERT INTO public.manifesto_carga
(nr_manifesto, fk_nr_notafiscal, vl_pesototal, qt_volumecarga, vl_totalmanifesto, fl_situacao, dt_embarque, dt_saida)
VALUES(1, 2, 800, 80, 9759.30, 'E', '2021-12-22', null);

INSERT INTO public.manifesto_carga
(nr_manifesto, fk_nr_notafiscal, vl_pesototal, qt_volumecarga, vl_totalmanifesto, fl_situacao, dt_embarque, dt_saida)
VALUES(1, 3, 800, 80, 9759.30, 'E', '2021-12-22', null);


-- manifesto 2

INSERT INTO public.manifesto_carga
(nr_manifesto, fk_nr_notafiscal, vl_pesototal, qt_volumecarga, vl_totalmanifesto, fl_situacao, dt_embarque, dt_saida)
VALUES(2, 4, 1960, 80, 23154.80, 'S', '2022-01-10', '2022-01-11');

INSERT INTO public.manifesto_carga
(nr_manifesto, fk_nr_notafiscal, vl_pesototal, qt_volumecarga, vl_totalmanifesto, fl_situacao, dt_embarque, dt_saida)
VALUES(2, 5, 1960, 80, 23154.80, 'S', '2022-01-10', '2022-01-11');

INSERT INTO public.manifesto_carga
(nr_manifesto, fk_nr_notafiscal, vl_pesototal, qt_volumecarga, vl_totalmanifesto, fl_situacao, dt_embarque, dt_saida)
VALUES(2, 6, 1960, 80, 23154.80, 'S', '2022-01-10', '2022-01-11');


-- manifesto 3

INSERT INTO public.manifesto_carga
(nr_manifesto, fk_nr_notafiscal, vl_pesototal, qt_volumecarga, vl_totalmanifesto, fl_situacao, dt_embarque, dt_saida)
VALUES(3, 7, 310, 80, 3254.89, 'P', null, null);

INSERT INTO public.manifesto_carga
(nr_manifesto, fk_nr_notafiscal, vl_pesototal, qt_volumecarga, vl_totalmanifesto, fl_situacao, dt_embarque, dt_saida)
VALUES(3, 8, 310, 80, 3254.89, 'P', null, null);

INSERT INTO public.manifesto_carga
(nr_manifesto, fk_nr_notafiscal, vl_pesototal, qt_volumecarga, vl_totalmanifesto, fl_situacao, dt_embarque, dt_saida)
VALUES(3, 9, 310, 80, 3254.89, 'P', null, null);


select * from caminhao;

select * from motorista;

select * from manifesto_carga;

commit;

