package com.forohub.api.controller;

import com.forohub.api.verificacionservice.VerificacionService;
import com.forohub.api.domain.usuario.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private VerificacionService verificacionService;

    @PostMapping
    public ResponseEntity<DatosRespuestaUsuario> registrarUsuario(@RequestBody @Valid DatosRegistroUsuario datos, UriComponentsBuilder uriComponentsBuilder){
        Usuario usuario=new Usuario(datos);
        DatosRespuestaUsuario datosRespuestaUsuario=new DatosRespuestaUsuario(usuarioRepository.save(usuario));
        URI url=uriComponentsBuilder.path("/usuarios/{id}").buildAndExpand(datosRespuestaUsuario.id()).toUri();
        return ResponseEntity.created(url).body(datosRespuestaUsuario);
    }

@GetMapping
public ResponseEntity<Page<DatosRespuestaUsuario>> listarUsuaerios(@PageableDefault(size = 3, sort = "nombre") Pageable paginacion) {
    return ResponseEntity.ok(usuarioRepository.findAll(paginacion).map(DatosRespuestaUsuario::new));

}
@GetMapping("/{id}")
public ResponseEntity<DatosRespuestaUsuario> mostrarUsuarioPorId(@PathVariable Long id){
        Usuario usuario=verificacionService.validarUsuarioExistente(id);
        return ResponseEntity.ok(new DatosRespuestaUsuario(usuario));
}

@DeleteMapping("/{id}")
@Transactional
public ResponseEntity eliminarUsuario(@PathVariable Long id){
        Usuario usuario=verificacionService.validarUsuarioExistente(id);
        usuarioRepository.delete(usuario);
        return ResponseEntity.noContent().build();
}

@PutMapping("/{id}")
@Transactional
public ResponseEntity actualizarUsuario(@PathVariable Long id,@RequestBody @Valid DatosActualizarUsuario datosActualizarUsuario){
        Usuario usuario=verificacionService.validarUsuarioExistente(id);
        usuario.actualizarUsuario(datosActualizarUsuario);
        return ResponseEntity.ok(new DatosRespuestaUsuario(usuario));
}

}
