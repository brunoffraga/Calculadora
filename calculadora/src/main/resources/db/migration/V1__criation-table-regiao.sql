create table calculadora(

    id bigint not null auto_increment,
    ativo tinyint not null,
    numeroA float not null,
    numeroB float not null,
    simbolos varchar(1) not null,
    total float not null,

    primary key(id)

);