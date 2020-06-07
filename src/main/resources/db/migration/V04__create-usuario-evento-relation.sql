create table usuario_evento (
    id               int primary key auto_increment,
    usuario_id       int, foreign key(usuario_id) references usuario(id),
    evento_id        int, foreign key(evento_id) references evento(id),
    classificacao    int
);