package com.forohub.api.domain.topico;

import jakarta.validation.constraints.NotNull;

public record DatosPorCursoYFecha(
        @NotNull
        Curso curso,
        @NotNull
        int fecha
) {
}
