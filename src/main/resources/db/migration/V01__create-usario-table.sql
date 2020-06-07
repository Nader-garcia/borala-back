create table usuario (
    id              int primary key auto_increment,
    nome            varchar(100),
    cpf             varchar(20),
    cel             varchar(15),
    email           varchar(45),
    data_nasc       date,
    estado          varchar(2),
    cidade          varchar(120),
    senha           varchar(50)
);