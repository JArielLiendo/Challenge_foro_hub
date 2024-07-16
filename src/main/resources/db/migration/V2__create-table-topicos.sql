CREATE TABLE topicos (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL UNIQUE,
    mensaje VARCHAR(500) NOT NULL UNIQUE,
    fecha_de_creacion DATETIME,
    fecha_de_actualizacion DATETIME,
    estado VARCHAR(255),
    autor_topico_id BIGINT,
    curso VARCHAR(255),
    FOREIGN KEY (autor_topico_id) REFERENCES usuarios(id) ON DELETE CASCADE
);