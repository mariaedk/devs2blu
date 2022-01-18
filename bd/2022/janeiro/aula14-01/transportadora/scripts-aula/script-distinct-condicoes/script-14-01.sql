
select distinct mc.nr_manifesto, mc.vl_pesototal , mc.qt_volumecarga , mc.fl_situacao 
from manifesto_carga mc 
where mc.fl_situacao  = 'E';



select *
from manifesto_carga mc 
where mc.fl_situacao in (select distinct mc.fl_situacao 
						from manifesto_carga mc 
						where mc.fl_situacao  = 'E');
					
	

					
-- vai retornar exatamente os dados que tem apenas na coluna fl_situacao (P,E,S)
select distinct mc.fl_situacao from manifesto_carga mc 




-- vai trazer todo mundo que tem como situações, E P ou S
select * 
from manifesto_carga mc 
where mc.fl_situacao = 'E'
   or mc.fl_situacao = 'P'
   or mc.fl_situacao = 'S'
   
-- outro jeito:
select * 
from manifesto_carga mc 
where mc.fl_situacao in ('E', 'P', 'S');

-- mais condições (apenas entra as datas especificadas abaixo e com nr_nota fiscal maior que 4)
select * 
from manifesto_carga mc 
where mc.fl_situacao in ('E', 'P', 'S')
	  and mc.dt_embarque between '2021-11-01' and '2021-11-30'
	  and mc.fk_nr_notafiscal > 4;
	 

-- mais condições (resgatou apenas entre os meses 11 e 12 e trouxe os dados que a data de saida é null)
-- aqui obrigatoriamente traz os meses 11 ou 12 E que tenham a data de saida null
select * 
from manifesto_carga mc 
where mc.fl_situacao in ('E', 'P', 'S')
	  and to_char(mc.dt_embarque, 'mm') in ('12', '11') 
	  and mc.dt_saida is null;


-- aqui traz data de embarque entre os meses 11 ou 12 OU traz data de saida null, ou seja, pode atender uma
	 -- ou as duas condições
select * 
from manifesto_carga mc 
where mc.fl_situacao in ('E', 'P', 'S')
	  and to_char(mc.dt_embarque, 'mm') in ('12', '11') 
	  or mc.dt_saida is null;
	 
	 

-- traz a quantidade de registros da tabela ou que satisfazem uma determinada condição
select count(*) from manifesto_carga mc ;



-- para saber se tem registros na tabela:
select distinct 1 from manifesto_carga mc ;

commit;







