--drop table supplier;
--drop table orders;

create table supplier ( 
supplier_id integer,
supplier_name varchar(30),
primary key (supplier_id));

create table orders (
id_order integer,
supplier_id integer,
order_date date,
primary key (id_order,supplier_id));

insert into supplier (supplier_id, supplier_name) values (10000, 'IBM');
insert into supplier (supplier_id, supplier_name) values (10001, 'Hewlett Packard');
insert into supplier (supplier_id, supplier_name) values (10002, 'Microsoft');
insert into supplier (supplier_id, supplier_name) values (10003, 'NVIDIA');

insert into orders (id_order, supplier_id, order_date) values (500125,10000, '2013-05-12');
insert into orders (id_order, supplier_id, order_date) values (500126,10001, '2013-05-13');
insert into orders (id_order, supplier_id, order_date) values (500127,10004, '2013-05-14');

select * from orders
select * from supplier


-- inner join junta estes dois comandos abaixo
select s.supplier_id , s.supplier_name 
from supplier s 

select o.id_order , o.order_date 
from orders o, supplier s 
where o.supplier_id = s.supplier_id 


-- INNER JOIN
select s.supplier_id , s.supplier_name, o.id_order , o.order_date 
from supplier s 
inner join orders o
on s.supplier_id = o.supplier_id 
-- retornou todas as linhas das tabelas supplier e orders onde ha um valor de supplier_id correspondente para ambas
-- ele n�o mostra o supplier_id 10,004 da tabela orders pois n�o ha registro dele na tabela suppliers
-- retorna todas as linhas das tabelas SUPPLIERS e ORDERS onde h� um valor de supplier_id 
-- correspondente em AMBAS as tabelas. Por isso o supplier_id 10,004 n�o mostra.

select o.supplier_id 
from orders o 



-- LEFT JOIN
select s.supplier_id , s.supplier_name , o.order_date 
from supplier s 
left outer join orders o 
on s.supplier_id = o.supplier_id 
-- 10,002 e 10,003 veio nulo pois n�o tem pedido deles
-- trouxe tudo da tabela A (supplier) e APENAS as linhas da tabela B (orders) onde os campos unidos s�o iguais
-- como os suppliers 10,002 e 10,003 n�o tem pedidos registrados na tabela orders, eles aparecem como null no order_date.


-- RIGHT JOIN
select s.supplier_id , s.supplier_name , o.id_order , o.order_date 
from supplier s 
right outer join orders o 
on s.supplier_id = o.supplier_id 
-- retorna todas as linhas da tabela orders(B) e apenas as linhas da tabela supplier(A)  onde os campos unidos
-- s�o iguais
-- se um valor supplier_id na tabela orders n�o existe na suppliers, aparece null
-- valor 10,004 aparece como null pois ele n�o existe na tabela suppliers, entretanto ele tem 
-- id_order e order_date registrados na tabela order, logo estas info s�o informadas
-- suplier id 10,004 existe na orders mas nao na supplier id = n�o atende condi��o e aparece como null


-- FULL OUTER JOIN 
select s.supplier_id , s.supplier_name , o.order_date, o.id_order 
from supplier s
full outer join orders o 
on s.supplier_id  = o.supplier_id ;

-- faz o inner, right e left
-- Retorna todas as linhas da tabela SUPPLIERS e todas as linhas da tabela ORDERS e sempre que a condi��o 
-- de jun��o n�o for atendida, null ser� aplicado para esses campos no conjunto de resultados.

-- Se um valor supplier_id na tabela de SUPPLIERS n�o existir na tabela ORDERS, todos os campos na tabela
-- ORDERS ser�o exibidos como null no conjunto de resultados.

-- Se um valor supplier _id na tabela ORDERS n�o existir na tabela SUPPLIERS, todos os campos na tabela 
-- SUPPLIERS ser�o exibidos como null no conjunto de resultados.
-- valor 10,004 existe na tabela orders e n�o existe na suppliers, logo os campos da tabela SUPPLIERS (supplier_id)
-- e (supplier_name) ficaram null, pois se n�o tem na suppliers, n�o tem o que mostrar

-- n�o existem dados dos supplier_id 10,002 e 10,003 na tabela orders, logo os campos da tabela ORDER
-- aparecer�o null (order_date), (id_order)









