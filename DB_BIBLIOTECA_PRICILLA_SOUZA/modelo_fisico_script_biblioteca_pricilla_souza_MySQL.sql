CREATE DATABASE DB_BIBLIOTECA;

USE DB_BIBLIOTECA;

CREATE TABLE TB_CLIENTE (
	cd_cpf VARCHAR(15) NOT NULL,
    nm_nome_cliente VARCHAR(100) NOT NULL,
    nm_email_cliente VARCHAR(100) NOT NULL,
    PRIMARY KEY (cd_cpf)
);

CREATE TABLE TB_LIVRO(
	cd_isbn BIGINT(255) NOT NULL,
    nm_nome_livro VARCHAR(100) NOT NULL,
    nm_genero_livro VARCHAR(100) NOT NULL,
    qt_exemplares BIGINT(255) NOT NULL,
    PRIMARY KEY (cd_isbn)
);

CREATE TABLE TB_EMPRESTIMO(
	qt_pego BIGINT(10) NOT NULL,
    qt_devolvido BIGINT(10) NOT NULL,
    dt_emprestimo DATE NOT NULL,
    dt_devolucao DATE NOT NULL,   
    cd_cpf VARCHAR(15) NOT NULL,
    cd_isbn BIGINT(255) NOT NULL,
    CONSTRAINT FK_TB_CLIENTE_CD_CPF FOREIGN KEY (cd_cpf) REFERENCES TB_CLIENTE (cd_cpf),
    CONSTRAINT FK_TB_LIVRO_CD_ISBN FOREIGN KEY (cd_isbn) REFERENCES TB_LIVRO (cd_isbn)    
);

ALTER TABLE TB_CLIENTE ADD CHECK (qt_pego<=5);

-- CADASTRANDO CLIENTES;

INSERT INTO TB_CLIENTE (
	cd_cpf,
    nm_nome_cliente,
    nm_email_cliente
) VALUES (
	'222.333.444-55', 
    'Pricilla Souza',
    'pricilla@souza.com'
);

INSERT INTO TB_CLIENTE (
	cd_cpf,
    nm_nome_cliente,
    nm_email_cliente
) VALUES (
	'555.777.888-99', 
    'Silvia Queen',
    'Silvia@queen.com'
);

INSERT INTO TB_CLIENTE (
	cd_cpf,
    nm_nome_cliente,
    nm_email_cliente
) VALUES (
	'111.666.999-33', 
    'Rafão Gratidão',
    'rafao@gratidao.com'
);

-- CADASTRANDO LIVROS e seus generos;

INSERT INTO TB_LIVRO (
	cd_isbn,
    nm_nome_livro,
    nm_genero_livro,
    qt_exemplares
) VALUES (
	3333.45, 
    '´Pé Grande',
    'Suspense',
    20
);

INSERT INTO TB_LIVRO (
	cd_isbn,
    nm_nome_livro,
    nm_genero_livro,
    qt_exemplares
) VALUES (
	'6546.77', 
    'A vida é bela',
    'Drama',
    15
);

INSERT INTO TB_LIVRO (
	cd_isbn,
    nm_nome_livro,
    nm_genero_livro,
    qt_exemplares
) VALUES (
	'6321.747', 
    'Largue mão de ser pé rapado',
    'Comedia',
    35
);

INSERT INTO TB_LIVRO (
	cd_isbn,
    nm_nome_livro,
    nm_genero_livro,
    qt_exemplares
) VALUES (
	'8671.687', 
    'O carinha que mora logo ali',
    'Ficcão',
    10
);

-- CADASTRANDO EMPRESTIMOS e devoluções;

INSERT INTO TB_EMPRESTIMO (
	qt_pego,
    qt_devolvido,
    dt_emprestimo,
    dt_devolucao,   
    cd_cpf,
    cd_isbn
) VALUES (
	2, 
    0,
    '2020/06/02',
    '2020/06/09',
    '222.333.444-55',
    8672
);

INSERT INTO TB_EMPRESTIMO (
	qt_pego,
    qt_devolvido,
    dt_emprestimo,
    dt_devolucao,   
    cd_cpf,
    cd_isbn
) VALUES (
	4, 
    2,
    '2020/06/01',
    '2020/06/08',
    '555.777.888-99',
    6547
);

INSERT INTO TB_EMPRESTIMO (
	qt_pego,
    qt_devolvido,
    dt_emprestimo,
    dt_devolucao,   
    cd_cpf,
    cd_isbn
) VALUES (
	3, 
    1,
    '2020/06/03',
    '2020/06/10',
    '111.666.999-33',
    6322
);

-- MESCLANDO TABELAS;

SELECT A.cd_cpf,
    nm_nome_cliente,
    B.cd_isbn,
    nm_nome_livro,
    nm_genero_livro,
    qt_pego,
    qt_devolvido,
    dt_emprestimo,
    dt_devolucao
FROM TB_EMPRESTIMO 
RIGHT JOIN TB_LIVRO B ON (TB_EMPRESTIMO.cd_isbn = B.cd_isbn)
LEFT JOIN TB_CLIENTE A ON (TB_EMPRESTIMO.cd_cpf = A.cd_cpf);   



-- PESQUISA DE DADOS;

SHOW COLUMNS FROM TB_CLIENTE;
SHOW COLUMNS FROM TB_LIVRO;
SHOW COLUMNS FROM TB_EMPRESTIMO;

SELECT * FROM TB_CLIENTE;
SELECT * FROM TB_LIVRO;
SELECT * FROM TB_EMPRESTIMO;