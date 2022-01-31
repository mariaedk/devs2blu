use escola;
create table aluno
(
	cd_aluno int auto_increment primary key,
    nm_aluno varchar(50) not null,
    nm_pai_aluno varchar(50) not null,
    nm_mae_aluno varchar(50) not null,
    dt_nascimento date,
    vlr_mediaAluno decimal(2,2)
);

create table avaliacao
(
	cd_avaliacao int auto_increment primary key,
    cd_aluno int references aluno(cd_aluno),
    nr_avaliacao int,
    vlr_nota decimal(2,2)
);
