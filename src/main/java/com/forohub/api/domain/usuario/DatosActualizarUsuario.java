package com.forohub.api.domain.usuario;

import jakarta.validation.constraints.Email;

public record DatosActualizarUsuario(
        @Email
        String email,
        String password
) {
}
