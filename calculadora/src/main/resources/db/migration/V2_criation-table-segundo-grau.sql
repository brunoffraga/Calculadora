create table segundograu(

    id bigint not null auto_increment,
    ativo tinyint not null,
    numeroA float not null,
    numeroB float not null,
    raiz1 float,
    raiz2 float,
    delta float,
    sqrtdelta float,
    total float,

    primary key(id)

);