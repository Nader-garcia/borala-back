create table edicao_evento (
    id       		int primary key auto_increment,
    evento_id       int, foreign key(evento_id) references evento(id),
    data_evento    	datetime
);