create table evento (
    id                 int primary key auto_increment,
    titulo             varchar(60),
    categoria_id       int, foreign key(categoria_id) references categoria_evento(id),
    organizador_id     int, foreign key(organizador_id) references usuario(id),
    endereco           varchar(60),
    cidade             varchar(30),
    capacidade         int,
    valor              double,
    publico            bit
);