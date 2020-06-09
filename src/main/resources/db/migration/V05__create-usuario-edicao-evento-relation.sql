create table usuario_edicao_evento (
    id               int primary key auto_increment,
    usuario_id       int, foreign key(usuario_id) references usuario(id),
    edicao_evento_id int, foreign key(edicao_evento_id) references edicao_evento(id),
    classificacao    int
);