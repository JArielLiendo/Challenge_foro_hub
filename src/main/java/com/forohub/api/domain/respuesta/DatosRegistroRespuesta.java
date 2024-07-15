package com.forohub.api.domain.respuesta;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosRegistroRespuesta(
        @NotNull
         Long topico_id,
        @NotNull
         Long autorRespuesta_id,
        @NotBlank
         String solucion
) {
}
