create table PRODUTO
(
	id_produto serial primary key,
	nm_produto varchar(25),
	dsc_produto varchar(40),
	qtd_estoque smallint
);

create table CLIENTE 
(
	id_cliente serial primary key,
	nm_cliente varchar(40),
	dt_nascimento date,
	nr_cpf varchar(15),
	nm_municipio varchar(20)
);
select * from cliente;