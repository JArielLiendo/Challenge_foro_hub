package com.forohub.api.controller;

import com.forohub.api.domain.usuario.DatosAutenticacionUsuario;
import com.forohub.api.domain.usuario.Usuario;
import com.forohub.api.infra.Security.DatosJWTToken;
import com.forohub.api.infra.Security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")

public class AutnticacionController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity autenticarUsuario (@RequestBody @Valid DatosAutenticacionUsuario datosAutenticacionUsuario){
        Authentication tokenDeAutenticacion = new UsernamePasswordAuthenticationToken(datosAutenticacionUsuario.nombre(), datosAutenticacionUsuario.password());
        var usuarioAutenticado=authenticationManager.authenticate(tokenDeAutenticacion);
        var JWTtoken = tokenService.generarToken((Usuario) usuarioAutenticado.getPrincipal());
        return ResponseEntity.ok(new DatosJWTToken(JWTtoken));
    }
}
