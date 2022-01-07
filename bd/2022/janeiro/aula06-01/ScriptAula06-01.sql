create table alunos
(
	codaluno serial,
	nomaluno varchar(30) not null,
	medaluno decimal(4,2),
	primary key (codaluno)
);

select * from alunos;

-- criar índice
create index ix_nome on alunos(nomaluno);

create table notas(
	codaluno integer not null,
	nravaliacao integer not null,
	vlrnota decimal(4,2) not null,
	primary key(codaluno, nravaliacao)
);

-- altera a tabela notas adicionando a restrição foreign key em codaluno 
-- prestando refereência a codaluno da tabela alunos
alter table notas 
add constraint fk_alunoNota -- nome da constraint
foreign key (codaluno) -- onde a constraint vai ser aplicada
references alunos (codaluno); -- referência ao campo da qual obtém a fk

------------------------------------------------------------------------------

-- usando comandos DML (Insert, Update e Delete)

-- INSERT

-- obs: não preciso informar o codaluno. Pq?
-- resposta: pq o codaluno é uma primary key que foi definida como SERIAL, vai incrementar automaticamente

insert into alunos (nomaluno, medaluno) values('JOÃO FILHO', 8);
insert into alunos (nomaluno, medaluno) values('MARIA DA SILVA', 6);
insert into alunos (nomaluno, medaluno) values('ADEMIR SILVA', 4);
insert into alunos (nomaluno, medaluno) values('CARLOS SILVANO', null);
insert into alunos (nomaluno, medaluno) values('KIARA SANTOS', 1);

-- SELECT
select * from alunos;

-- deletar todos os dados da tabela alunos
delete from alunos;

-- rollback fez todos os dados voltarem à tabela
rollback;


-- inserindo com commit explicito
insert into alunos (nomaluno, medaluno) values('MARINA SILVA', null);
commit;

-- se usar o comando commit e quiser dar rollback depois, não vai dar certo
-- commit deve ser usado quando estiver tudo 100% certo

-- populando a tabela NOTAS

insert into notas(codaluno, nravaliacao, vlrnota) values (8, 1, 8.5);
insert into notas(codaluno, nravaliacao, vlrnota) values (8, 2, 4);
insert into notas(codaluno, nravaliacao, vlrnota) values (8, 3, 6.2);

insert into notas(codaluno, nravaliacao, vlrnota) values (9, 1, 5);
insert into notas(codaluno, nravaliacao, vlrnota) values (9, 2, 8);
insert into notas(codaluno, nravaliacao, vlrnota) values (9, 3, 9);

insert into notas(codaluno, nravaliacao, vlrnota) values (10, 1, 8.7);
insert into notas(codaluno, nravaliacao, vlrnota) values (10, 2, 5.5);
insert into notas(codaluno, nravaliacao, vlrnota) values (10, 3, 7.8);

insert into notas(codaluno, nravaliacao, vlrnota) values (11, 1, 2.3);
insert into notas(codaluno, nravaliacao, vlrnota) values (11, 2, 4.5);
insert into notas(codaluno, nravaliacao, vlrnota) values (11, 3, 9.5);

insert into notas(codaluno, nravaliacao, vlrnota) values (12, 1, 2.3);
insert into notas(codaluno, nravaliacao, vlrnota) values (12, 2, 4.5);
insert into notas(codaluno, nravaliacao, vlrnota) values (12, 3, 9.5);

select * from notas;

commit;

-- select mais claro da tabela notas
select n.codaluno CodigoAluno, n.nravaliacao NrAvaliacao, n.vlrnota VlrNota
from notas n;


-- usando order by para ordernar os registros
-- o padrão de ordenação é ascendente (ASC)
select n.codaluno CodigoAluno, n.nravaliacao NrAvaliacao, n.vlrnota VlrNota
from notas n
order by n.codaluno, n.nravaliacao desc;

select * from notas;


/* feito para demonstração
update notas 
set vlrnota = 7
where codaluno = 8 and nravaliacao = 2; */


-- selecionando as notas de um aluno específico, neste caso o aluno numero 9
select n.codaluno CodigoAluno, n.nravaliacao NrAvaliacao, n.vlrnota VlrNota
from notas n
where n.codaluno = 9
order by n.codaluno, n.nravaliacao;


-- selecionando notas de um intervalo específico
select n.codaluno CodigoAluno, n.nravaliacao NrAvaliacao, n.vlrnota VlrNota
from notas n
where n.vlrnota between 5 and 8
order by n.vlrnota;


select * from notas;
commit;


-- é possível clonar tabelas.

-- clonando uma tabela:
-- drop table notas_bkp;
create table notas_bkp as (select * from notas);
select * from notas_bkp;


-- selecionando as notas de notas_bkp de forma ordenada
select n.codaluno, n.nravaliacao, n.vlrnota
from notas_bkp n
order by n.codaluno, n.nravaliacao;


-- visualizando o nome do aluno com código 8
select a.nomaluno from alunos a
where a.codaluno = 8


-- criando uma coluna dentro da nova tabela notas_bkp
alter table notas_bkp 
add column nomaluno varchar(30)

