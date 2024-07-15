package com.forohub.api.domain.usuario;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;


public record DatosRegistroUsuario(
        @NotBlank
        String nombre,
        @NotBlank
        String password,
        @NotBlank
        @Email
        String email
) {
}
