package com.forohub.api.domain.respuesta;

import java.time.LocalDateTime;

public record DatosRetornoRespuesta(
        String mensaje,
        String solucion,
        String autor,
        LocalDateTime fechaDeCreacion
) {
    public DatosRetornoRespuesta(Respuesta respuesta){
        this(respuesta.getMensaje(),respuesta.getSolucion(),
                respuesta.getAutorRespuesta().getNombre(),respuesta.getFechaDeCreacion());
    }
}
