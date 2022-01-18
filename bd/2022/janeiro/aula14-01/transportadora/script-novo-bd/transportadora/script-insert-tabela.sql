/* 
    nr_placa varchar(09) NOT NULL,
    dt_manutencao Date NOT NULL,
    dt_proxManutencao Date NOT NULL,
    PRIMARY KEY (nr_placa)
*/

-- caminhao --------------------------------------------------------------

insert into caminhao
values ('PCK-5458','2020-12-22','2022-03-22');

insert into caminhao
values ('ABC-1234','2020-10-15','2022-01-15');

insert into caminhao
values ('WKK-2789','2020-11-08','2022-02-08');

insert into caminhao
values ('CKK-7524','2020-11-04','2022-02-04');

select * from caminhao;

-- motorista -------------------------------------------------------

insert into motorista(nr_cnh, nm_motorista)
values (1992882,'Brenda R. Winder');

insert into motorista (nr_cnh, nm_motorista)
values (1734336,'José Castro Alves');

insert into motorista (nr_cnh, nm_motorista)
values (0749800,'Júlio Almeida Barbosa');

insert into motorista (nr_cnh, nm_motorista)
values (7744654,'Fernanda Gomes Lima');

select * from motorista;

-- nota fiscal -------------------------------------------------

insert into nota_fiscal(nr_nota, dt_emissao, vl_pesototal, vl_totalnota)
values (1,'2021-12-22',300.00,3254.60);

insert into nota_fiscal(nr_nota, dt_emissao, vl_pesototal, vl_totalnota)
values (2,'2021-12-22',675.00,4525.80);

insert into nota_fiscal(nr_nota, dt_emissao, vl_pesototal, vl_totalnota)
values (3,'2021-12-22',450.00,3683.60);

insert into nota_fiscal(nr_nota, dt_emissao, vl_pesototal, vl_totalnota)
values (4,'2021-11-14',250.00,1680.35);

insert into nota_fiscal(nr_nota, dt_emissao, vl_pesototal, vl_totalnota)
values (5,'2021-11-14',252.00,1700.00);

insert into nota_fiscal(nr_nota, dt_emissao, vl_pesototal, vl_totalnota)
values (6,'2021-11-16',12800.00,25680.00);

insert into nota_fiscal(nr_nota, dt_emissao, vl_pesototal, vl_totalnota)
values (7,'2021-10-02',14600.00,11645.00);

insert into nota_fiscal(nr_nota, dt_emissao, vl_pesototal, vl_totalnota)
values (8,'2021-10-02',1252.00,868.00);

insert into nota_fiscal(nr_nota, dt_emissao, vl_pesototal, vl_totalnota)
values (9,'2021-10-02',864.00,1985.45);

select * from nota_fiscal;

select sum(nota_fiscal.vl_pesototal), sum(nota_fiscal.vl_totalnota)
from nota_fiscal  
where nota_fiscal.nr_nota in (1,2,3);

-- Situacao manifesto (E = Embarcado  P = Pendente  S = SAIDA)

-- manifesto 1 -----------------------------------------------------------------------

INSERT INTO public.manifesto_carga
(nr_manifesto, fk_nr_notafiscal, vl_pesototal, qt_volumecarga, vl_totalmanifesto, fl_situacao, dt_embarque, dt_saida)
VALUES(1, 1, 1425.00, 80, 11464.00, 'E', '2021-12-22', null);

INSERT INTO public.manifesto_carga
(nr_manifesto, fk_nr_notafiscal, vl_pesototal, qt_volumecarga, vl_totalmanifesto, fl_situacao, dt_embarque, dt_saida)
VALUES(1, 2, 1425.00, 80, 11464.00, 'E', '2021-12-22', null);

INSERT INTO public.manifesto_carga
(nr_manifesto, fk_nr_notafiscal, vl_pesototal, qt_volumecarga, vl_totalmanifesto, fl_situacao, dt_embarque, dt_saida)
VALUES(1, 3, 1425.00, 80, 11464.00, 'E', '2021-12-22', null);

select * from manifesto_carga;
-- manifesto 2 ---------------------------------------------------------------------

INSERT INTO public.manifesto_carga
(nr_manifesto, fk_nr_notafiscal, vl_pesototal, qt_volumecarga, vl_totalmanifesto, fl_situacao, dt_embarque, dt_saida)
VALUES(2, 4, 13302.00, 120, 29060.35,'S', '2021-11-16','2021-11-17');

INSERT INTO public.manifesto_carga
(nr_manifesto, fk_nr_notafiscal, vl_pesototal, qt_volumecarga, vl_totalmanifesto, fl_situacao, dt_embarque, dt_saida)
VALUES(2, 5, 13302.00, 120, 29060.35,'S','2021-11-16','2021-11-17');

INSERT INTO public.manifesto_carga
(nr_manifesto, fk_nr_notafiscal, vl_pesototal, qt_volumecarga, vl_totalmanifesto, fl_situacao, dt_embarque, dt_saida)
VALUES(2, 6, 13302.00, 120, 29060.35,'S','2021-11-16','2021-11-17');


-- manifesto 3 --------------------------------------------------------------

INSERT INTO public.manifesto_carga
(nr_manifesto, fk_nr_notafiscal, vl_pesototal, qt_volumecarga, vl_totalmanifesto, fl_situacao, dt_embarque, dt_saida)
VALUES(3, 7, 18716.00, 185, 14498.45, 'P', null, null);

INSERT INTO public.manifesto_carga
(nr_manifesto, fk_nr_notafiscal, vl_pesototal, qt_volumecarga, vl_totalmanifesto, fl_situacao, dt_embarque, dt_saida)
VALUES(3, 8,  18716.00, 185, 14498.45,'P', null, null);

INSERT INTO public.manifesto_carga
(nr_manifesto, fk_nr_notafiscal, vl_pesototal, qt_volumecarga, vl_totalmanifesto, fl_situacao, dt_embarque, dt_saida)
VALUES(3, 9,  18716.00, 185, 14498.45,'P', null, null);


select * from caminhao;

select * from motorista;

select * from manifesto_carga;

commit;

-- -------------------------------------------------------------------------------------

-- UPDATE NA TABELA CAMINHAO
update caminhao
set nr_placa = 'CXX-8844'
where nr_placa = 'CKK-7524';


-- select na tabela caminhao
-- traz placas em ordem alfabética

select c.nr_placa "Placa", 
to_char(c.dt_manutencao, 'dd/mm/yyyy') as "Data Manutenção", 
to_char(c.dt_proxManutencao, 'dd/mm/yyyy') as "Data Próx Manutenção"
from caminhao c
order by 1; -- desc para pedir ordem decrescente alfabética


-- caminhão com data de manutenção mais recente -------------------------------------------------------------------------------

select c.nr_placa as "Número placa", c.dt_manutencao as "Data manutenção"
from caminhao c
where c.dt_manutencao = (select max(dt_manutencao) from caminhao);



-- informações sobre o manifesto ---------------------------------------------------------------------------------------------

-- The COALESCE() function returns the first non-null value in a list.
select 
mc.nr_manifesto "Manifesto",
mc.fk_nr_notafiscal "Nota fiscal",
mc.vl_pesototal "Peso Manifesto",
mc.qt_volumecarga "Volume manifesto",
to_char(mc.dt_embarque, 'dd/mm/yyyy') "Data Embarque",
case mc.fl_situacao -- dependendo do que estiver armazenado na situação, considerando que é apenas um char, ele vai fazer as comparações, tipo um switch no java
 when 'E' then 'Embarcado'
 when 'P' then 'Pendente'
 when 'S' then 'Saída'
end as "Situação",
to_char(coalesce(mc.dt_saida, '01/01/1900'), 'dd/mm/yyyy') "Data Saída" 
--mc.dt_saida -> comparação
from manifesto_carga mc 
where mc.nr_manifesto = 1;
-- basicamente, aonde tem null, o coalesce vai fazer retornar o 01-01-1900 no lugar de null



-- teste:
select 
mc.nr_manifesto "Manifesto",
mc.fk_nr_notafiscal "Nota fiscal",
mc.vl_pesototal "Peso Manifesto",
mc.qt_volumecarga "Volume manifesto",
to_char(coalesce(mc.dt_embarque, '01/01/1999'), 'dd/mm/yyyy') "Data Embarque",
case mc.fl_situacao -- dependendo do que estiver armazenado na situação, considerando que é apenas um char, ele vai fazer as comparações, tipo um switch no java
 when 'E' then 'Embarcado'
 when 'P' then 'Pendente'
 when 'S' then 'Saída'
end as "Situação",
to_char(coalesce(mc.dt_saida, '01/01/1900'), 'dd/mm/yyyy') "Data Saída" 
--mc.dt_saida -> comparação
from manifesto_carga mc 



-- USANDO A FUNÇÃO UPPER na situação -------------------------------------------------------------------------------------------------

select
mc.nr_manifesto "Manifesto",
mc.fk_nr_notafiscal "Nota fiscal",
mc.vl_pesototal "Peso Manifesto",
mc.qt_volumecarga "Volume manifesto",
to_char(coalesce(mc.dt_embarque, '01/01/1999'), 'dd/mm/yyyy') "Data Embarque",
case mc.fl_situacao -- dependendo do que estiver armazenado na situação, considerando que é apenas um char, ele vai fazer as comparações, tipo um switch no java
 when 'E' then upper('Embarcado')
 when 'P' then upper('Pendente')
 when 'S' then upper('Saída')
end as "Situação",
to_char(coalesce(mc.dt_saida, '01/01/1900'), 'dd/mm/yyyy') "Data Saída" 
--mc.dt_saida -> comparação
from manifesto_carga mc 



-- FUNÇÕES DE STRINGS ----------------------------------------------------------------------------------------------------------

-- buscar parte do nome do motorista usando LIKE
-- motoristas começando com 'J'

select *
from motorista m
where m.nm_motorista like 'J%';

-- motoristas que tem 'da' no nome
select *
from motorista m
where m.nm_motorista like '%da%';

-- motoristas que coemçam com 'b' no nome
select * 
from motorista m
where m.nm_motorista like 'B%';

-- motoristas cujo nome terminam em 'a'

select *
from motorista m
where m.nm_motorista like '%a';


update motorista 
set nm_motorista = 'Brenda R. Winder';

commit;






