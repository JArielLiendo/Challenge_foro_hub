package com.forohub.api.controller;

import com.forohub.api.domain.respuesta.DatosRegistroRespuesta;
import com.forohub.api.domain.respuesta.DatosRetornoRespuesta;
import com.forohub.api.domain.respuesta.Respuesta;
import com.forohub.api.domain.respuesta.RespuestaRepository;
import com.forohub.api.domain.topico.Topico;
import com.forohub.api.domain.topico.TopicoRepository;
import com.forohub.api.verificacionservice.VerificacionService;
import com.forohub.api.domain.usuario.Usuario;
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
import java.util.List;

@RestController
@RequestMapping("/respuestas")
public class RespuestaController {

    @Autowired
    private RespuestaRepository respuestasRepository;
    @Autowired
    private TopicoRepository topicoRepository;
    @Autowired
    private VerificacionService verificacionService;

    @PostMapping
    @Transactional
    public ResponseEntity<DatosRetornoRespuesta> registrarRespuesta(@RequestBody @Valid DatosRegistroRespuesta datos,
                                                                    UriComponentsBuilder uriComponentsBuilder){

        Topico topico=verificacionService.validarTopicoActivo(datos.topico_id());
        Usuario usuarioRespuesta = verificacionService.validarUsuarioExistente(datos.autorRespuesta_id());
        Respuesta respuesta=respuestasRepository.save(new Respuesta(datos,usuarioRespuesta,topico));
        URI url=uriComponentsBuilder.path("/respuestas/{id}").buildAndExpand(respuesta.getId()).toUri();
        return ResponseEntity.created(url).body(new DatosRetornoRespuesta(respuesta));
    }

    @GetMapping
    public ResponseEntity<Page<DatosRetornoRespuesta>>liatarRespuestas(@PageableDefault(size = 3, sort = "id")Pageable paginacion){
        Page<Respuesta>listaDeRespuestas=respuestasRepository.listarRespuesta(paginacion);
        return ResponseEntity.ok(listaDeRespuestas.map(DatosRetornoRespuesta::new));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DatosRetornoRespuesta>listarRespuestaPorId(@PathVariable Long id){
        Respuesta respuesta=verificacionService.verificarRespuestaTopicoActivo(id);
        return ResponseEntity.ok(new DatosRetornoRespuesta(respuesta));
    }
    @GetMapping("/respuestasportopico/{id}")
    public ResponseEntity<List<DatosRetornoRespuesta>>listarRespuestaPorTopico(@PathVariable Long id){
        Topico topico=verificacionService.validarTopicoActivo(id);
        List<Respuesta>listaDeRespuestasPorTopico=respuestasRepository.listarRespuestaPorTopico(id);
        return ResponseEntity.ok(listaDeRespuestasPorTopico.stream().map(DatosRetornoRespuesta::new).toList());
    }



}
