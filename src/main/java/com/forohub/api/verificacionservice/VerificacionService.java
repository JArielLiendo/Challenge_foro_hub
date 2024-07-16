package com.forohub.api.verificacionservice;

import com.forohub.api.domain.respuesta.Respuesta;
import com.forohub.api.domain.respuesta.RespuestaRepository;
import com.forohub.api.domain.topico.Estado;
import com.forohub.api.domain.topico.Topico;
import com.forohub.api.domain.topico.TopicoRepository;
import com.forohub.api.domain.usuario.Usuario;
import com.forohub.api.domain.usuario.UsuarioRepository;
import com.forohub.api.infra.ValidacionDeExixtencia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class VerificacionService {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private TopicoRepository topicoRepository;
    @Autowired
    private RespuestaRepository respuestaRepository;

    public Usuario validarUsuarioExistente(Long id){
        if (!usuarioRepository.findById(id).isPresent()){
            throw new ValidacionDeExixtencia("Este id del usuario no fue encontrado");
        }
        return usuarioRepository.getReferenceById(id);
    }
    public Topico validarExistenciaTopico(Long id){
        if (!topicoRepository.findById(id).isPresent()){
            throw new ValidacionDeExixtencia("El topico para el id: " + id + ", no existe.");
        }
        return topicoRepository.getReferenceById(id);
    }

    public Topico validarTopicoActivo(Long id){
        Topico topico=validarExistenciaTopico(id);
        if (topico.getEstado() == Estado.DESACTIVADO){
            throw new ValidacionDeExixtencia("No se pueden realizar consultas sobre Topicos DESACTIVADOS");
        }
        return topico;
    }
    public Respuesta verificarExistenciaRespuesta(Long id){
        if (!respuestaRepository.findById(id).isPresent()){
            throw new ValidacionDeExixtencia("Este id de la respuesta no fue encontrado");
        }
        return respuestaRepository.getReferenceById(id);

    }
    public Respuesta verificarRespuestaTopicoActivo(Long id){
        Respuesta respuesta=verificarExistenciaRespuesta(id);
        if (respuesta.getTopico().getEstado()!=Estado.ACTIVO){
            throw new ValidacionDeExixtencia("No se puede mostrar respuestas para topicos DESACTIVADOS");
        }
        return respuesta;
    }

}