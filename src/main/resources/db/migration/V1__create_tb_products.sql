CREATE TABLE tb_products (
    id          BIGSERIAL       PRIMARY KEY,
    name        VARCHAR(100)    NOT NULL,
    description VARCHAR(255)    NOT NULL,
    price       NUMERIC(12, 2)  NOT NULL,
    CONSTRAINT chk_tb_products_price_positive CHECK (price > 0)
);

COMMENT ON TABLE tb_products IS 'Produtos da loja';
COMMENT ON COLUMN tb_products.id IS 'Identificador sequencial';
COMMENT ON COLUMN tb_products.name IS 'Nome do produto (3 a 100 caracteres na API)';
COMMENT ON COLUMN tb_products.description IS 'Descrição do produto';
COMMENT ON COLUMN tb_products.price IS 'Preço unitário (até 10 dígitos inteiros e 2 decimais)';
