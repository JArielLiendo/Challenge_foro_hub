package com.forohub.api.controller;

import com.forohub.api.domain.topico.*;
import com.forohub.api.domain.usuario.Usuario;
import com.forohub.api.domain.usuario.UsuarioRepository;
import com.forohub.api.verificacionservice.VerificacionService;
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
import java.util.stream.Collectors;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository topicoRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private VerificacionService verificacionService;

    @PostMapping
    @Transactional
    public ResponseEntity<DatosRespuestaTopico> registrarTopico(@RequestBody @Valid DatosRegistroTopico datosTopico, UriComponentsBuilder uriComponentsBuilder){
       Usuario usuario = verificacionService.validarUsuarioExistente(datosTopico.id_usuario());
       Topico topico=topicoRepository.save(new Topico(datosTopico, usuario));
        URI url = uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(url).body(new DatosRespuestaTopico(topico));
    }


    @GetMapping("/primeros10topicos")
    public ResponseEntity<List<DatoslistarTopico>> listar10Topicos() {
        List<Topico> topicos = topicoRepository.listarPrimeros10Topicos();
        List<DatoslistarTopico> datos = topicos.stream().map(DatoslistarTopico::new).collect(Collectors.toList());
        return ResponseEntity.ok(datos);
    }

    @GetMapping
    public ResponseEntity<Page<DatoslistarTopico>> listarTopicos(@PageableDefault(size = 3, sort = "titulo") Pageable paginacion) {
        return ResponseEntity.ok(topicoRepository.buscarTopicoPorEstadoActivo(paginacion).map(DatoslistarTopico::new));

    }

    @GetMapping("/{id}")
    public ResponseEntity<DatosRespuestaTopico> mostrarTopicoPorId(@PathVariable Long id){
        Topico topico=verificacionService.validarTopicoActivo(id);
        return ResponseEntity.ok(new DatosRespuestaTopico(topico));
    }

    @GetMapping("/porcursoyfecha")
    public ResponseEntity<List<DatosRespuestaTopico>> mostrarTopicoPorCursoYFecha(@RequestBody @Valid DatosPorCursoYFecha datosPorCursoYFecha){
        List<Topico> topicos=topicoRepository.buscarPorCursoYFecha(datosPorCursoYFecha.curso(), datosPorCursoYFecha.fecha());
        List<DatosRespuestaTopico>datos=topicos.stream().map(DatosRespuestaTopico::new).toList();
        return ResponseEntity.ok(datos);

    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminarTopico(@PathVariable Long id){
        Topico topico= verificacionService.validarExistenciaTopico(id);
        topicoRepository.deleteById(topico.getId());
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity desactivarActualizarTopico(@PathVariable Long id, @RequestBody @Valid DatosActualizarTopico datosActualizarTopico){

        Topico topico= verificacionService.validarExistenciaTopico(id);
        topico.actualizarTopico(datosActualizarTopico);
        return ResponseEntity.ok(new DatosRespuestaTopico(topico));
    }

}
