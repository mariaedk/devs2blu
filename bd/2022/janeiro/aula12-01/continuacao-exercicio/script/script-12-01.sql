-- FUN��ES DE STRINGS ----------------------------------------------------------------------------------------------------------

-- buscar parte do nome do motorista usando LIKE
-- motoristas come�ando com 'J'

select *
from motorista m
where m.nm_motorista like 'J%';

-- motoristas que tem 'da' no nome
select *
from motorista m
where m.nm_motorista like '%da%';

-- motoristas que coem�am com 'b' no nome
select * 
from motorista m
where m.nm_motorista like 'B%';

select * 
from motorista m
where m.nm_motorista ilike  '%b%';

-- ilike seleciona independente de ser upper ou lowercase

-- motoristas cujo nome terminam em 'a'

select *
from motorista m
where m.nm_motorista like '%a';


update motorista 
set nm_motorista = 'Brenda R. Winder';

commit;

-- fun��es matematicas --------------------------------------------
select
sum(nf.vl_pesototal) "Peso Total", -- soma
round(avg(nf.vl_pesototal), 2) "Peso m�dio total", -- m�dia sendo arredonda em duas casas
max(nf.vl_pesototal) "Peso total m�ximo", -- valor m�ximo
min(nf.vl_pesototal) "Peso total m�nimo", -- valor m�nimo
count(*) "Quantidade de pesos"
from nota_fiscal nf



-- calculando o total de pesos por ano de emiss�o de nota fiscal-------------------
select
to_char(nf.dt_emissao, 'yyyy')  "Data emiss�o",
sum(nf.vl_pesototal) "Peso total"
from nota_fiscal nf 
group by 1
order by 1; -- ordena por data


-- calculando o total de pesos por m�s por extenso de emiss�o de nota fiscal-------------------
select
to_char(nf.dt_emissao, 'TMMonth')  "Data emiss�o",
sum(nf.vl_pesototal) "Peso total"
from nota_fiscal nf 
group by 1
order by 1 desc; -- ordena por data


-- criar uma tabela de log de faturamento
create table log_fatura
(
	msg_log varchar(80)
);

-- inserir um registro com data de emissao, nr fatura, valor fatura
insert into log_fatura(msg_log) values ('Data emiss�o: 22/12/2021 NF: 456877  Valor Faturado: 25568.50');
select * from log_fatura;

-- criar uma tabela para armazenar os campos resgatados do LOG
create table resumo_fatura
(
	dt_emissao Date,
	nr_fatura integer,
	vlr_fatura decimal(8,2)
);


-- inserir os campos do log na tabela
select 
to_date(substring(lf.msg_log, 15, 10), 'dd/mm/yyyy') "Data", -- qual string quero pegar, a partir de qual posi��o quero pegar e quantos bytes vou querer pegar
to_number(substring(lf.msg_log, position('NF: ' in lf.msg_log) + 3, 7), '9999999') "NF", -- procure o nf dentro do msg_log, pule 3 posi��es e pegue os 7 proximos bytes.
to_number(substring(lf.msg_log, position('Valor Faturado: ' in lf.msg_log) + 15, 9), '9g999g999.99') "Valor"
from log_fatura lf
-- na hora de extrair o dado, ele retorna a data em como esta salva para o banco

insert into resumo_fatura(dt_emissao, nr_fatura, vlr_fatura)
(
select 
to_date(substring(lf.msg_log, 15, 10), 'dd/mm/yyyy') "Data", -- qual string quero pegar, a partir de qual posi��o quero pegar e quantos bytes vou querer pegar
to_number(substring(lf.msg_log, position('NF: ' in lf.msg_log) + 3, 7), '9999999') "NF", -- procure o nf dentro do msg_log, pule 3 posi��es e pegue os 7 proximos bytes.
to_number(substring(lf.msg_log, position('Valor Faturado: ' in lf.msg_log) + 15, 9), '9g999g999.99') "Valor"
from log_fatura lf
);

-- ele sabe que o primeiro select to_date vai para o dt_emissao e que os select to_number v�o para nr_fatura e vlr_fatura pois os campos est�o em ordem, ele preenche de acordo com a ordem.
-- se a formata��o n�o estivesse condizente com o tipo de dado a inserir, daria erro.

select dt_emissao, count(*)
from resumo_fatura a
group by a.dt_emissao
having count(*) > 1
-- comando para verificar registros duplicados


COMMIT;
