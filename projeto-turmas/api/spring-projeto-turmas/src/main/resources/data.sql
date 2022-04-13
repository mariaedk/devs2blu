INSERT INTO pessoa(nome, idade, endereco, sexo) VALUES ('Ramon', 32, 'Rua Alface', 'M');
INSERT INTO pessoa(nome, idade, endereco, sexo) VALUES ('Ana', 20, 'Rua Laranja', 'F');
INSERT INTO pessoa(nome, idade, endereco, sexo) VALUES ('Nicole', 18, 'Rua Café', 'F');
INSERT INTO pessoa(nome, idade, endereco, sexo) VALUES ('Professor Julio', 35, 'Rua Amendoim', 'M');

INSERT INTO professor(pessoa_id) VALUES (4);

INSERT INTO aluno(ano, pessoa_id) VALUES (5, 1);
INSERT INTO aluno(ano, pessoa_id) VALUES (5, 2);
INSERT INTO aluno(ano, pessoa_id) VALUES (5, 3);

INSERT INTO turma(nome, periodo, max_alunos, professor_id) VALUES ('Turma 1', 'Matutino', 20, 1);
INSERT INTO turma(nome, periodo, max_alunos, professor_id) VALUES ('Turma 2', 'Vespertino', 20, 1);
INSERT INTO turma(nome, periodo, max_alunos, professor_id) VALUES ('Turma 3', 'Noturno', 20, 1);
