package com.forohub.api.domain.topico;


import java.time.LocalDateTime;

public record DatosRespuestaTopico(
        Long id_topico,
        Long id_usuario,
        Curso curso,
        String titulo,
        String mensaje,
        Estado estado,
        LocalDateTime fechaDeCreacion,
        LocalDateTime fechaDeActualizacion
) {
    public DatosRespuestaTopico(Topico topico){
        this(topico.getId(), topico.getAutorTopico().getId(), topico.getCurso(), topico.getTitulo(),
                topico.getMensaje(),topico.getEstado(),topico.getFechaDeCreacion(),topico.getFechaDeActualizacion());
    }
}
