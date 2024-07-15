CREATE TABLE topicos (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL UNIQUE,
    mensaje VARCHAR(500) NOT NULL UNIQUE,
    fecha_de_creacion DATETIME,
    fecha_de_actualizacion DATETIME,
    estado VARCHAR(255) NOT NULL,
    usuario_id BIGINT NOT NULL,
    curso VARCHAR(255) NOT NULL,
    FOREIGN KEY (usuario_id) REFERENCES usuarios(id)
);

