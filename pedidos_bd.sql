CREATE DATABASE pedidos_bd;

USE pedidos_bd;

CREATE TABLE IF NOT EXISTS clientes (
    id_cliente INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    apellido VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    telefono VARCHAR(15),
    direccion TEXT
);

CREATE TABLE IF NOT EXISTS productos (
    id_producto INT AUTO_INCREMENT PRIMARY KEY,
    nombre_producto VARCHAR(100) NOT NULL,
    descripcion TEXT,
    precio DECIMAL(10, 2) NOT NULL,
    stock INT NOT NULL
);

CREATE TABLE IF NOT EXISTS pedidos (
    id_pedido INT AUTO_INCREMENT PRIMARY KEY,
    id_cliente INT NOT NULL,
    fecha_pedido DATETIME DEFAULT CURRENT_TIMESTAMP,
    estado ENUM('Pendiente', 'Procesado', 'Enviado', 'Entregado', 'Cancelado') DEFAULT 'Pendiente',
    FOREIGN KEY (id_cliente) REFERENCES clientes(id_cliente)
);

CREATE TABLE IF NOT EXISTS detalles_pedido (
    id_detalle INT AUTO_INCREMENT PRIMARY KEY,
    id_pedido INT NOT NULL,
    id_producto INT NOT NULL,
    cantidad INT NOT NULL,
    precio_unitario DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (id_pedido) REFERENCES pedidos(id_pedido),
    FOREIGN KEY (id_producto) REFERENCES productos(id_producto)
);

INSERT INTO clientes (nombre, apellido, email, telefono, direccion)
VALUES 
('Juan', 'Pérez', 'juan.perez@email.com', '555-1234', 'Calle Ficticia 123'),
('María', 'González', 'maria.gonzalez@email.com', '555-5678', 'Avenida Real 456');

INSERT INTO productos (nombre_producto, descripcion, precio, stock)
VALUES 
('Laptop', 'Laptop Dell 15 pulgadas', 800.00, 50),
('Smartphone', 'Smartphone Samsung Galaxy', 300.00, 100),
('Tablet', 'Tablet Apple iPad 10 pulgadas', 400.00, 75);

INSERT INTO pedidos (id_cliente, estado)
VALUES
(1, 'Pendiente'),  
(2, 'Procesado');  

INSERT INTO detalles_pedido (id_pedido, id_producto, cantidad, precio_unitario)
VALUES
(1, 1, 1, 800.00),  
(1, 2, 2, 300.00),  
(2, 3, 1, 400.00); 
