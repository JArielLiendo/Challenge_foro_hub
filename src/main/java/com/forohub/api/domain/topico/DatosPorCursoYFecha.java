package com.forohub.api.domain.topico;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DatosPorCursoYFecha(
        @NotNull
        Curso curso,
        @NotNull
        int fecha
) {
}
