
INSERT INTO clientes (id, nombre, email) VALUES 
(1, 'Juan Perez', 'juan@example.com'), 
(2, 'Ana Gomez', 'ana@example.com');

INSERT INTO articulos (id, nombre, precio) VALUES 
(1, 'Lapiz', 0.50), 
(2, 'Cuaderno', 2.00), 
(3, 'Boligrafo', 1.20);

INSERT INTO pedidos (id, fecha, cliente_id) VALUES 
(1, '2023-01-10', 1), 
(2, '2023-01-11', 2);

INSERT INTO pedido_articulo (id, pedido_id, articulo_id, cantidad) VALUES 
(1, 1, 1, 3), 
(2, 1, 2, 1), 
(3, 2, 2, 2), 
(4, 2, 3, 1);
