CREATE TABLE respuestas (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    mensaje TEXT NOT NULL,
    solucion TEXT NOT NULL,
    fecha_de_creacion DATETIME,
    autor_respuesta_id BIGINT,
    topico_id BIGINT,
    FOREIGN KEY (autor_respuesta_id) REFERENCES usuarios(id) ON DELETE CASCADE,
    FOREIGN KEY (topico_id) REFERENCES topicos(id) ON DELETE CASCADE
);
