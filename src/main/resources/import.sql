
--PRODUTOS

INSERT INTO tb_produtos (nome, preco, quantidade_estoque) VALUES ('Relógio Esportivo Masculino', 199.99, 20);
INSERT INTO tb_produtos (nome, preco, quantidade_estoque) VALUES ('Pulseira Feminina Prata 925', 79.90, 50);
INSERT INTO tb_produtos (nome, preco, quantidade_estoque) VALUES ('Anel Solitário Ouro 18k', 499.99, 15);
INSERT INTO tb_produtos (nome, preco, quantidade_estoque) VALUES ('Colar de Pérolas Naturais', 299.90, 25);
INSERT INTO tb_produtos (nome, preco, quantidade_estoque) VALUES ('Brinco de Argola Folheado a Ouro', 49.90, 100);
INSERT INTO tb_produtos (nome, preco, quantidade_estoque) VALUES ('Pulseira de Couro Unissex', 59.99, 60);
INSERT INTO tb_produtos (nome, preco, quantidade_estoque) VALUES ('Relógio Digital Smartwatch', 249.99, 30);
INSERT INTO tb_produtos (nome, preco, quantidade_estoque) VALUES ('Colar de Pingente Coração', 99.90, 45);
INSERT INTO tb_produtos (nome, preco, quantidade_estoque) VALUES ('Óculos de Sol Aviador Clássico', 149.99, 40);
INSERT INTO tb_produtos (nome, preco, quantidade_estoque) VALUES ('Carteira de Couro Masculina', 89.90, 75);
INSERT INTO tb_produtos (nome, preco, quantidade_estoque) VALUES ('Porta-Cartão Minimalista', 39.90, 120);
INSERT INTO tb_produtos (nome, preco, quantidade_estoque) VALUES ('Brinco Feminino Zircônia', 29.90, 200);
INSERT INTO tb_produtos (nome, preco, quantidade_estoque) VALUES ('Pingente com Pedra Ametista', 199.90, 18);
INSERT INTO tb_produtos (nome, preco, quantidade_estoque) VALUES ('Anel de Formatura Feminino', 399.99, 10);
INSERT INTO tb_produtos (nome, preco, quantidade_estoque) VALUES ('Relógio Clássico Analógico', 349.90, 12);


INSERT INTO tb_usuarios (nome, cpf, email,password) VALUES ('Pedro Santos', '11122233344', 'pedro.santos@example.com', '$2a$10$VUbRSTk7cPEa9C4.cKH/P.maf9WwqInwamg3ZLHskJFr6y99rzjRC');
INSERT INTO tb_usuarios (nome, cpf, email,password) VALUES ('Ana Souza', '55566677788', 'ana.souza@example.com', '$2a$10$VUbRSTk7cPEa9C4.cKH/P.maf9WwqInwamg3ZLHskJFr6y99rzjRC');
INSERT INTO tb_usuarios (nome, cpf, email,password) VALUES ('Carlos Pereira', '99988877766', 'carlos.pereira@example.com', '$2a$10$VUbRSTk7cPEa9C4.cKH/P.maf9WwqInwamg3ZLHskJFr6y99rzjRC');
INSERT INTO tb_usuarios (nome, cpf, email,password) VALUES ('Fernanda Costa', '12312312312', 'fernanda.costa@example.com', '$2a$10$VUbRSTk7cPEa9C4.cKH/P.maf9WwqInwamg3ZLHskJFr6y99rzjRC');
INSERT INTO tb_usuarios (nome, cpf, email,password) VALUES ('Bruno Almeida', '32132132132', 'bruno.almeida@example.com', '$2a$10$VUbRSTk7cPEa9C4.cKH/P.maf9WwqInwamg3ZLHskJFr6y99rzjRC');
INSERT INTO tb_usuarios (nome, cpf, email,password) VALUES ('Juliana Nunes', '45645645645', 'juliana.nunes@example.com', '$2a$10$VUbRSTk7cPEa9C4.cKH/P.maf9WwqInwamg3ZLHskJFr6y99rzjRC');
INSERT INTO tb_usuarios (nome, cpf, email,password) VALUES ('Marcelo Rocha', '78978978978', 'marcelo.rocha@example.com', '$2a$10$VUbRSTk7cPEa9C4.cKH/P.maf9WwqInwamg3ZLHskJFr6y99rzjRC');
INSERT INTO tb_usuarios (nome, cpf, email,password) VALUES ('Patrícia Lima', '01201201201', 'patricia.lima@example.com', '$2a$10$VUbRSTk7cPEa9C4.cKH/P.maf9WwqInwamg3ZLHskJFr6y99rzjRC');
INSERT INTO tb_usuarios (nome, cpf, email,password) VALUES ('Gustavo Mendes', '34534534534', 'gustavo.mendes@example.com', '$2a$10$VUbRSTk7cPEa9C4.cKH/P.maf9WwqInwamg3ZLHskJFr6y99rzjRC');
INSERT INTO tb_usuarios (nome, cpf, email,password) VALUES ('Bianca Ferreira', '67867867867', 'bianca.ferreira@example.com', '$2a$10$VUbRSTk7cPEa9C4.cKH/P.maf9WwqInwamg3ZLHskJFr6y99rzjRC');
INSERT INTO tb_usuarios (nome, cpf, email,password) VALUES ('Ricardo Carvalho', '90190190190', 'ricardo.carvalho@example.com', '$2a$10$VUbRSTk7cPEa9C4.cKH/P.maf9WwqInwamg3ZLHskJFr6y99rzjRC');
INSERT INTO tb_usuarios (nome, cpf, email,password) VALUES ('Amanda Duarte', '23423423423', 'amanda.duarte@example.com', '$2a$10$VUbRSTk7cPEa9C4.cKH/P.maf9WwqInwamg3ZLHskJFr6y99rzjRC');
INSERT INTO tb_usuarios (nome, cpf, email,password) VALUES ('Leonardo Barbosa', '56756756756', 'leonardo.barbosa@example.com', '$2a$10$VUbRSTk7cPEa9C4.cKH/P.maf9WwqInwamg3ZLHskJFr6y99rzjRC');
INSERT INTO tb_usuarios (nome, cpf, email,password) VALUES ('João da Silva', '12345678900', 'joao.silva@example.com', '$2a$10$VUbRSTk7cPEa9C4.cKH/P.maf9WwqInwamg3ZLHskJFr6y99rzjRC');


INSERT INTO tb_role (authority) VALUES ('ROLE_OPERATOR');
INSERT INTO tb_role (authority) VALUES ('ROLE_ADMIN');

INSERT INTO tb_usuario_role (usuario_id, role_id) VALUES (1, 1);
INSERT INTO tb_usuario_role (usuario_id, role_id) VALUES (2, 1);
INSERT INTO tb_usuario_role (usuario_id, role_id) VALUES (2, 2);

