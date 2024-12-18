-- INSERINDO DADOS NA TABELA ESTUDANTE
INSERT INTO estudante (nome, senha, cep, email, data_nascimento) VALUES
('Ana Silva', 'senha123', '12345678', 'ana.silva@email.com', '2000-05-15'),
('João Pereira', 'senha456', '87654321', 'joao.pereira@email.com', '1998-09-22'),
('Maria Oliveira', 'senha789', '11223344', 'maria.oliveira@email.com', '2001-01-10');

-- INSERINDO DADOS NA TABELA INSTITUICAO
INSERT INTO instituicao (nome, cep, email, senha, numero_mec, campus, publica, sigla) VALUES
('Universidade Federal do Rio de Janeiro', '20040020', 'contato@ufrj.br', 'ufrj2024', 123456, 'Cidade Universitária', true, 'UFRJ'),
('Instituto Federal de São Paulo', '01046900', 'contato@ifsp.edu.br', 'ifsp2024', 654321, 'Campus São Paulo', true, 'IFSP'),
('Faculdade ABC', '09123001', 'contato@facabc.edu.br', 'facabc2024', 789012, 'Centro', false, 'FACABC');

-- INSERINDO DADOS NA TABELA CURSO
INSERT INTO curso (nome, periodo, duracao, modalidade, area_conhecimento, sigla) VALUES
('Engenharia de Software', 'MATUTINO', 8, 'PRESENCIAL', 'ENGENHARIAS', 'ENGSW'),
('Medicina', 'VESPERTINO', 12, 'PRESENCIAL', 'CIENCIAS_DA_SAUDE', 'MED'),
('Administração', 'NOTURNO', 8, 'MISTO', 'CIENCIAS_SOCIAIS_APLICADAS', 'ADM');

-- INSERINDO DADOS NA TABELA INFRAESTRUTURA
INSERT INTO infraestrutura (descricao) VALUES
('Biblioteca'),
('Laboratórios de Informática'),
('Quadras Poliesportivas'),
('Auditório');

-- INSERINDO DADOS NA TABELA PUBLICACAO
INSERT INTO publicacao (descricao, data_publicacao) VALUES
('Evento sobre inteligência artificial', NOW()),
('Seminário de economia sustentável', NOW()),
('Palestra sobre saúde mental', NOW());

-- INSERINDO DADOS NA TABELA FAVORITO
INSERT INTO favorito (id_estudante, id_instituicao) VALUES
(1, 1),
(2, 2),
(3, 3);

-- INSERINDO DADOS NA TABELA AVALIACAO
INSERT INTO avaliacao (nota, comentario, data_avaliacao, id_instituicao, id_estudante) VALUES
(5, 'Ótima universidade, excelente infraestrutura!', NOW(), 1, 1),
(4, 'Professores muito qualificados.', NOW(), 2, 2),
(3, 'Falta investimento em tecnologia.', NOW(), 3, 3);

-- INSERINDO DADOS NA TABELA INSTITUICAO_INFRAESTRUTURA
INSERT INTO instituicao_infraestrutura (id_instituicao, id_infraestrutura) VALUES
(1, 1),
(1, 2),
(2, 1),
(3, 3),
(3, 4);

-- INSERINDO DADOS NA TABELA INSTITUICAO_CURSO
INSERT INTO instituicao_curso (id_instituicao, id_curso) VALUES
(1, 1),
(1, 2),
(2, 3),
(3, 1);

-- INSERINDO DADOS NA TABELA INSTITUICAO_PUBLICACAO
INSERT INTO instituicao_publicacao (id_instituicao, id_publicacao) VALUES
(1, 1),
(2, 2),
(3, 3);
