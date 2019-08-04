use estudo;

select * from usuario;

create table vendas(
id integer not null auto_increment,
idUsuario integer not null,
nomeProduto varchar(50) not null,
qtd varchar(4) not null,
dtVenda date not null,
primary key(id)
);

insert into vendas(idUsuario,nomeProduto,qtd,dtVenda)
values
(1,'Monitor LG 25" Ultrawide 21:9','20', STR_TO_DATE( "03/08/2019", "%m/%d/%Y"));

insert into vendas(idUsuario,nomeProduto,qtd,dtVenda)
values
(1,'Teclado Microsoft Wired 600 Keyboard','60', STR_TO_DATE( "03/08/2019", "%m/%d/%Y"));

insert into vendas(idUsuario,nomeProduto,qtd,dtVenda)
values
(1,'Notebook Samsung i3-6º geração 2.00gHz Preto','5', STR_TO_DATE( "03/08/2019", "%m/%d/%Y"));

update vendas set nomeProduto = 'Monitor LG 25"' where id = 1;
update vendas set nomeProduto = 'Teclado Microsoft' where id = 2;
update vendas set nomeProduto = 'Notebook' where id = 3;

insert into vendas(idUsuario,nomeProduto,qtd,dtVenda)
values
(1,'Mouse','1', STR_TO_DATE( "03/08/2019", "%m/%d/%Y"));

insert into vendas(idUsuario,nomeProduto,qtd,dtVenda)
values
(1,'HeadPhone','10', STR_TO_DATE( "03/08/2019", "%m/%d/%Y"));

insert into vendas(idUsuario,nomeProduto,qtd,dtVenda)
values
(1,'Caixa de Som','1', STR_TO_DATE( "03/08/2019", "%m/%d/%Y"));

select * from vendas;

create table carro (
id integer not null auto_increment,
img varchar(500) not null,
nome varchar(50) not null,
marca varchar(50) not null,
ano varchar(4) not null,
valor varchar(10) not null,
primary key(id)
);

insert into carro
(img,nome,marca,ano,valor)
value
('https://pbs.twimg.com/media/EBFImrEWwAIKl0r?format=png&name=900x900','Polo','Volkswagens','2003','20.000')
;

insert into carro
(img,nome,marca,ano,valor)
value
('https://pbs.twimg.com/media/DGqBkDzXUAAwLaL?format=jpg&name=4096x4096','Idea Attractive','Fiat','2014','19.000')
;
-- Fiat Idea https://pbs.twimg.com/media/DGqBkDzXUAAwLaL?format=jpg&name=4096x4096

insert into carro
(img,nome,marca,ano,valor)
value
('https://abrilquatrorodas.files.wordpress.com/2016/12/fiesta1.jpg','Fiesta Sport','Ford','2019','65.500')
;

insert into carro
(img,nome,marca,ano,valor)
value
('https://img2.icarros.com/dbimg/imgmodelo/4/2381_6.png','New Fiesta SE','Ford','2019','59.001')
;

insert into carro
(img,nome,marca,ano,valor)
value
('https://s2.glbimg.com/Xz8kfnpltyVU2F_yT6yoeJXP9Bs=/620x413/e.glbimg.com/og/ed/f/original/2018/10/05/chevette.jpg','Chevette SE 87','Chevrolet','1987','30.000')
;

delete from carro where id in (5,6);

select * from carro;

insert into usuario(nome,login,senha) value ('','a','a');
select * from usuario;


create table moto (
id integer not null auto_increment,
img varchar(500) not null,
nome varchar(50) not null,
marca varchar(50) not null,
ano varchar(4) not null,
valor varchar(10) not null,
primary key(id)
);

insert into moto
(img,nome,marca,ano,valor)
value
('https://cdn.salaodocarro.com.br/_upload/motos/2019/01/11/honda-biz-125-2019-10208-0.jpg','Honda Biz Flexone','Honda','2019','3.500')
;

insert into moto
(img,nome,marca,ano,valor)
value
('https://i.ytimg.com/vi/h-GEwG4cdwo/maxresdefault.jpg','Hornet Carburada','Honda','2006','14.500')
;


insert into moto
(img,nome,marca,ano,valor)
value
('https://img.olx.com.br/images/15/159929031142780.jpg','Pop 110i','Honda','2019','8.500')
;

insert into moto
(img,nome,marca,ano,valor)
value
('https://odia.ig.com.br/_midias/jpg/2018/12/04/yamaha_lander_2019_2-8882648.jpg','Lander','Yamaha','2019','11.900')
;

select * from moto;

select * from carro;