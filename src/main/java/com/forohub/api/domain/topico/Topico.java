package com.forohub.api.domain.topico;

import com.forohub.api.domain.respuesta.Respuesta;
import com.forohub.api.domain.usuario.Usuario;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity(name = "Topico")
@Table(name = "topicos")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")

public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensaje;
    @Column(columnDefinition = "DATETIME(0)")
    private LocalDateTime fechaDeCreacion;
    @Column(columnDefinition = "DATETIME(0)")
    private LocalDateTime fechaDeActualizacion;
    @Enumerated(EnumType.STRING)
    private Estado estado;

    @ManyToOne
    @JoinColumn(name = "autor_topico_id")
    private Usuario autorTopico;

    @Enumerated(EnumType.STRING)
    private Curso curso;

    @OneToMany(mappedBy = "topico", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    private List<Respuesta> respuestas;

    public Topico(DatosRegistroTopico datos,Usuario usuario){
        this.titulo=datos.titulo();
        this.mensaje=datos.mensaje();
        this.fechaDeCreacion=LocalDateTime.now();
        this.estado=Estado.ACTIVO;
        this.autorTopico =usuario;
        this.curso=datos.curso();
    }
    public void actualizarTopico(DatosActualizarTopico datos){
        if (datos.estado() != null) {
            this.estado=datos.estado();
        }
        if (datos.titulo()!=null){
            this.titulo= datos.titulo();
        }
        if (datos.mensaje()!=null){
            this.mensaje= datos.mensaje();
        }

        if (datos.titulo()!=null || datos.mensaje()!=null ){
            this.fechaDeActualizacion= LocalDateTime.now();
        }
        }

        public void desactivarTopico(){
        this.estado=Estado.DESACTIVADO;
        }

    }


