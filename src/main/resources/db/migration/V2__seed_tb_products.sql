INSERT INTO tb_products (name, description, price) VALUES
    ('Notebook Dell Inspiron 15', 'Notebook 15,6" Intel Core i5, 8 GB RAM, SSD 256 GB', 3499.90),
    ('Mouse Logitech MX Master 3', 'Mouse sem fio ergonômico com sensor de alta precisão', 429.99),
    ('Teclado Keychron K2', 'Teclado mecânico compacto 75% com switches Gateron Brown', 589.00),
    ('Monitor LG UltraWide 29"', 'Monitor IPS 29" Full HD, 75 Hz, HDMI e DisplayPort', 1299.50),
    ('Headset HyperX Cloud II', 'Headset gamer com som surround 7.1 e microfone destacável', 499.90),
    ('Webcam Logitech C920', 'Webcam Full HD 1080p com autofoco e microfone estéreo', 379.00),
    ('SSD Samsung 990 Pro 1TB', 'SSD NVMe M.2 PCIe 4.0, leitura até 7450 MB/s', 649.99),
    ('Cadeira Gamer DXRacer', 'Cadeira ergonômica com apoio lombar e reclinação até 135°', 1899.00),
    ('Hub USB-C Anker 7 em 1', 'Hub com HDMI 4K, USB 3.0, leitor SD e entrega de energia 100 W', 299.90),
    ('Suporte articulado para monitor', 'Braço duplo VESA para dois monitores de até 27 polegadas', 459.00);

SELECT setval(
    pg_get_serial_sequence('tb_products', 'id'),
    COALESCE((SELECT MAX(id) FROM tb_products), 1)
);
