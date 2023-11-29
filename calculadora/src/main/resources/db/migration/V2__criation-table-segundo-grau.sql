create table segundograu(

    id bigint not null auto_increment,
    ativo tinyint not null,
    
    a float not null,
    b float not null,
    c float not null,
    raiz1 float,
    raiz2 float,
    delta float,
    sqrtdelta float,

    erro varchar(255),

    primary key(id)

);