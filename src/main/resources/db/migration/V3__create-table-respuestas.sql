
CREATE TABLE respuestas (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    mensaje TEXT NOT NULL,
    solucion TEXT NOT NULL,
    fecha_de_creacion DATETIME,
    autor_respuesta_id BIGINT,
    topico_id BIGINT,
    autor_topico_id BIGINT,
    FOREIGN KEY (autor_respuesta_id) REFERENCES usuarios(id),
    FOREIGN KEY (topico_id) REFERENCES topicos(id),
    FOREIGN KEY (autor_topico_id) REFERENCES usuarios(id)  -- Nueva columna y clave foránea
);
