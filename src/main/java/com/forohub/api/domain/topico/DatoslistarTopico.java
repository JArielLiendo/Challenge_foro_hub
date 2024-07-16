package com.forohub.api.domain.topico;

import java.time.LocalDateTime;

public record DatoslistarTopico(
        String tituloDelTopico,
        String mensaje,
        String nombreUsuario,
        Curso curso,
        LocalDateTime fechaDeCreacion

) {
    public DatoslistarTopico(Topico topico){
        this(topico.getTitulo(), topico.getMensaje(), topico.getAutorTopico().getNombre(),
                topico.getCurso(),topico.getFechaDeCreacion());
    }
}
