package com.forohub.api.domain.respuesta;

import com.forohub.api.domain.topico.Topico;
import com.forohub.api.domain.usuario.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity(name = "Respuesta")
@Table(name = "respuestas")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Respuesta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String mensaje;
    private String solucion;
    private LocalDateTime fechaDeCreacion;

    @ManyToOne
    @JoinColumn(name = "topico_id")
    private Topico topico;

    @ManyToOne
    @JoinColumn(name = "autor_respuesta_id")
    private Usuario autorRespuesta;

    public Respuesta(DatosRegistroRespuesta datos, Usuario usuario, Topico topico){
        this.mensaje= topico.getMensaje();
        this.solucion=datos.solucion();
        this.fechaDeCreacion=LocalDateTime.now();
        this.topico=topico;
        this.autorRespuesta=usuario;

    }

}
