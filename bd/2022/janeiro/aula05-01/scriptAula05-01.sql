create table alunos
(
	codaluno serial,
	nomaluno varchar(30) not null,
	medaluno decimal(4,2),
	primary key (codaluno)
);

select * from alunos;

create index ix_nome on alunos(nomaluno);

create table notas(
	codaluno integer not null,
	nravaliacao integer not null,
	vlrnota decimal(4,2) not null,
	primary key(codaluno, nravaliacao)
);
